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
public class BookUpdateListener {
    @Autowired
    BookQueryDAO bookQueryDAO;
    @Autowired
    BookQueryServiceImpl bookService;


    @KafkaListener(topics = {"updatebooktopic"}, groupId = "gid4")
    public void receive(@Payload BookDto bookDTO) {
        System.out.println("received update message="+ bookDTO.toString());
        Book book = BookAdapter.getBookFromBookDto(bookDTO);
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setAuthor(bookDTO.getAuthor());
        bookQueryDAO.save(book);
    }


}
