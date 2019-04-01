package gov.poc.demo;

import com.google.gson.Gson;
import com.poc.demo.pojo.MsgType;
import gov.poc.demo.dto.TransactionEvent;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class Producer {

  Logger logger = LoggerFactory.getLogger(Producer.class);
  private TransactionEvent transactionEvent = new TransactionEvent();

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @Value("${app.topic.foo}")
  private String topic;

  @Autowired
  public CacheManager cacheManager;

  public void processMessage(MsgType message) {
    if (message == null || message.getTrans() == null) {
      return;
    }

    if (!message.getTrans().isIsLast()) {
      transactionEvent.getMessages().add(message);
    } else {
      transactionEvent.getMessages().add(message);
      cacheManager.getCache("event").putIfAbsent(transactionEvent.getMessages().get(0).getTrans().getCmitLSN(), transactionEvent);
      kafkaTemplate.send(topic, transactionEvent.getMessages().get(0).getTrans().getCmitLSN() ,new Gson().toJson(transactionEvent));
      transactionEvent.getMessages().clear();
      kafkaTemplate.setProducerListener(new ProducerListener() {
        @Override
        public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
          logger.info("SUCCESS");
          if (transactionEvent.getMessages().isEmpty()) {
            logger.info("EMPTY CACHE");
            return;
          }
          logger.info("CACHE  >>>>>>>>>>> " + cacheManager.getCache("event").get(transactionEvent.getMessages().get(0).getTrans().getCmitLSN()).get());
          cacheManager.getCache("event").evict(transactionEvent.getMessages().get(0).getTrans().getCmitLSN());
          logger.info("CACHE  REMOVED >>>>>>>>>>> " + cacheManager.getCache("event").get(transactionEvent.getMessages().get(0).getTrans().getCmitLSN()));
        }

        @Override
        public void onSuccess(String topic, Integer partition, Object key, Object value,
            RecordMetadata recordMetadata) {
          logger.info("SUCCESS2");
        }

        @Override
        public void onError(ProducerRecord producerRecord, Exception exception) {
          logger.info("ERROR");
        }

        @Override
        public void onError(String topic, Integer partition, Object key, Object value,
            Exception exception) {
          logger.info("ERROR2");
        }
      });
    }
  }
}