package book.integration;

import book.Service.dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, BookDto bookDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        String bookDtoString ;
        try{
      bookDtoString = objectMapper.writeValueAsString(bookDTO);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(topic, bookDtoString);
    }
}
