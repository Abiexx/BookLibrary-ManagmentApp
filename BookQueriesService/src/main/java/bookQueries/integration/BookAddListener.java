package bookQueries.integration;

import bookQueries.domain.Book;
import bookQueries.Repository.BookQueryDAO;
import bookQueries.service.BookQueryServiceImpl;
import bookQueries.service.Dto.BookAdapter;
import bookQueries.service.Dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;



@Service
public class BookAddListener {
    @Autowired
    BookQueryDAO bookQueryDAO;
    @Autowired
    BookQueryServiceImpl bookService;
    private Logger logger = LoggerFactory.getLogger(BookAddListener.class);

    @KafkaListener(topics = {"addbooktopic"}, groupId = "gid")
//    public void receive(@Payload BookDto bookDTO) {
////        System.out.println("received message="+ bookDTO.getTitle());
//        logger.info(" >>  Received confirmation: " + bookDTO.toString());
//        Book book = BookAdapter.getBookFromBookDto(bookDTO);
//        bookQueryDAO.save(book);

//    }

    public void receive(@Payload String bookDtoString) {
        ObjectMapper objectMapper = new ObjectMapper();
        BookDto bookDto;
        try {
            bookDto = objectMapper.readValue(bookDtoString , BookDto.class);
            Book book = BookAdapter.getBookFromBookDto(bookDto);
            bookQueryDAO.save(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

