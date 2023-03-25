package borrowings.integration;


import borrowings.Domain.Borrowing;
import borrowings.Repository.BorrowingDAO;
import borrowings.service.BorrowingsService;
import borrowings.service.Dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerListener {
    @Autowired
    BorrowingDAO borrowingDAO;
    @Autowired
    BorrowingsService borrowingsService;

    @KafkaListener(topics = {"updateCustomertopic"}, groupId = "gid2")
    public void receive(@Payload String customerDtoString) {
        System.out.println("customer recieved ====" +customerDtoString);

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerDto customerDto;
        try{
            customerDto = objectMapper.readValue(customerDtoString, CustomerDto.class);
            List<Borrowing> borrowings = borrowingDAO.findCBorrowingsByCustomerNumber(customerDto.getCustomerNumber());
            System.out.println("*****borrowings fetched from DB *********" );
            for (Borrowing borrowing:borrowings){
                if(borrowing.getCustomer().getCustomerNumber() == customerDto.getCustomerNumber()) {
                    System.out.println("received borrowing ------  "+ borrowing);
                    borrowing.setCustomer(customerDto);
                    borrowingDAO.save(borrowing);
                }
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
