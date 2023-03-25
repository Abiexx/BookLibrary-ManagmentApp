package book.Service;

import book.Repository.IBookDAO;
import book.Service.adapter.BookAddapter;
import book.Service.dto.BookDto;
import book.domain.Book;
import book.integration.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookCommandServiceImp implements IBookCommandService {

    @Autowired
    private IBookDAO bookDAO;

    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public BookDto addBook(BookDto bookDTO) {
        Book book = BookAddapter.getBookFromBookDTO(bookDTO);
        bookDAO.save(book);
        kafkaSender.send("addbooktopic",bookDTO);
        return bookDTO;
    }

    @Override
    public BookDto updateBook(long isbn, BookDto bookDTO) {
        Optional<Book> optionalBook = bookDAO.findById(isbn);
        if (optionalBook.isPresent()){
            Book book = BookAddapter.getBookFromBookDTO(bookDTO);
            bookDAO.save(book);
            kafkaSender.send("updatebooktopic",bookDTO);
        }
        return bookDTO;
    }


    @Override
    public BookDto deleteBook(long isbn) {
        Book book = bookDAO.findById(isbn).get();
        BookDto bookDTO = BookAddapter.getBookDTOFromBook(book);
        bookDAO.deleteById(isbn);
        kafkaSender.send("deletebooktopic",bookDTO);
        return bookDTO;
    }
}
