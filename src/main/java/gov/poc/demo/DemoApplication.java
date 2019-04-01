package gov.poc.demo;

import gov.poc.demo.emulator.MessageGenerator;
import javax.jms.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
@EnableJms
public class DemoApplication {

  @Autowired
  private JmsTemplate jmsTemplate;
  @Autowired
  private MessageGenerator messageGenerator;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CacheManager cacheManager() {
    return new ConcurrentMapCacheManager("event");
  }

  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter() {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    return converter;
  }

  @Bean
  public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
      DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    // This provides all boot's default to this factory, including the message converter
    configurer.configure(factory, connectionFactory);
    // You could still override some of Boot's default if necessary.
    return factory;
  }

  @GetMapping("send")
  String send() {
    try {
      new Thread(() -> {
        for(int i=0; i<1000; ++i) {
          try {
            Thread.sleep(1000);
            jmsTemplate.convertAndSend("DEV.QUEUE.1", messageGenerator.generateMessageType(false, "" + i + " " + Thread.currentThread().getId()));
            jmsTemplate.convertAndSend("DEV.QUEUE.1", messageGenerator.generateMessageType(false, "" + i + " " + Thread.currentThread().getId()));
            jmsTemplate.convertAndSend("DEV.QUEUE.1", messageGenerator.generateMessageType(true, "" + i + " " + Thread.currentThread().getId()));
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }).start();
      return "OK";
    } catch (JmsException ex) {
      ex.printStackTrace();
      return "FAIL";
    }
  }

  @GetMapping("recv")
  String recv() {
    try {
      return jmsTemplate.receiveAndConvert("DEV.QUEUE.1").toString();
    } catch (JmsException ex) {
      ex.printStackTrace();
      return "FAIL";
    }
  }
}
