package gov.poc.demo;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Consumer {

  @KafkaListener(topics = {"replication"})
  public void listen(ConsumerRecord<?, ?> record) throws Exception {

    Optional<?> kafkaMessage = Optional.ofNullable(record.value());

    if (kafkaMessage.isPresent()) {
      Object message = kafkaMessage.get();
    }

  }
}