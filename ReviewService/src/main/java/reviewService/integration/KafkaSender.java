package reviewService.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reviewService.service.Dto.ReviewDto;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, ReviewDto reviewDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        String reviewDtoString ;
        try{
            reviewDtoString = objectMapper.writeValueAsString(reviewDTO);
            kafkaTemplate.send(topic, reviewDtoString);
                    System.out.println("kafkaReviewSender sent a message *****");

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
