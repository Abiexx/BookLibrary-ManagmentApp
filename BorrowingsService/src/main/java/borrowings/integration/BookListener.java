package borrowings.integration;

import borrowings.Domain.Borrowing;
import borrowings.Repository.BorrowingDAO;
import borrowings.service.BorrowingsService;
import borrowings.service.Dto.BookDto;
import borrowings.service.Dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListener {
    @Autowired
    BorrowingDAO borrowingDAO;
    @Autowired
    BorrowingsService borrowingsService;

    @KafkaListener(topics = {"updatebooktopic"}, groupId = "gid")
    public void receive(@Payload String bookDtoString) {
        System.out.println("book recieved ====" +bookDtoString);
        ObjectMapper objectMapper = new ObjectMapper();
        BookDto bookDto;
        try{
            bookDto = objectMapper.readValue(bookDtoString, BookDto.class);
            List<Borrowing> borrowings = borrowingDAO.findBorrowingsByIsbn(bookDto.getIsbn());
            System.out.println("*****borrowings fetched from DB *********" );
            for (Borrowing borrowing:borrowings){
                if(borrowing.getBook().getIsbn() == bookDto.getIsbn()) {
                    System.out.println("received borrowing ------  " + borrowing);
                    borrowing.setBook(bookDto);
                    borrowingDAO.save(borrowing);
                }
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}