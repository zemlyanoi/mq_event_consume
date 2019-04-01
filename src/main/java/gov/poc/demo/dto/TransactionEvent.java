package gov.poc.demo.dto;

import com.poc.demo.pojo.MsgType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.CacheConfig;

@CacheConfig(cacheNames = "transactionEvent")
public class TransactionEvent {

  private List<MsgType> messages;

  public List<MsgType> getMessages() {
    if (messages == null) {
      messages = new ArrayList<>();
    }
    return messages;
  }

  public void setMessage(List<MsgType> messages) {
    this.messages = messages;
  }
}
