package gov.poc.demo;

import com.poc.demo.pojo.MsgType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
  Logger logger = LoggerFactory.getLogger(Receiver.class);

  @Autowired
  private Producer producer;

  @JmsListener(destination = "DEV.QUEUE.1", containerFactory = "myFactory")
  public void receiveMessage(MsgType message) {
    logger.info("Received <" + message + ">");
    producer.processMessage(message);
  }

}