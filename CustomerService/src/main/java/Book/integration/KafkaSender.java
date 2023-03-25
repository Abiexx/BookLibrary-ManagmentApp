package Book.integration;

import Book.service.Dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, CustomerDto customerDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        String customerDtoString ;
        try{
            customerDtoString = objectMapper.writeValueAsString(customerDTO);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(topic, customerDtoString);
    }
//    public void sendToBorrowing(String topic, CustomerDto customerDTO){
//        CustomerDto customerDtotoSend = new CustomerDto();
//        customerDtotoSend.setCustomerNumber(customerDTO.getCustomerNumber());
//        customerDtotoSend.setName(customerDTO.getName());
//        ObjectMapper objectMapper = new ObjectMapper();
//        String customerDtoString ;
//        try{
//            customerDtoString = objectMapper.writeValueAsString(customerDtotoSend);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//        kafkaTemplate.send(topic, customerDtoString);
//    }
}
