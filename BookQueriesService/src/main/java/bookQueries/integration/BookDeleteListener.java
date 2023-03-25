package bookQueries.integration;

import bookQueries.domain.Book;
import bookQueries.Repository.BookQueryDAO;
import bookQueries.service.BookQueryServiceImpl;
import bookQueries.service.Dto.BookAdapter;
import bookQueries.service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BookDeleteListener {
    @Autowired
    BookQueryDAO bookQueryDAO;
    @Autowired
    BookQueryServiceImpl bookService;


    @KafkaListener(topics = {"deletebooktopic"}, groupId = "gid2")
    public void receive(@Payload BookDto bookDTO) {
        System.out.println("received message ========="+ bookDTO.getTitle());
        Book book = BookAdapter.getBookFromBookDto(bookDTO);
        bookQueryDAO.delete(book);
    }

}
