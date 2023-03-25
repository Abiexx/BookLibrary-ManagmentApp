package bookQueries.service;

import bookQueries.service.Dto.BookAdapter;
import bookQueries.service.Dto.BookDto;
import bookQueries.service.Dto.BookDtos;
import bookQueries.domain.Book;
import bookQueries.Repository.BookQueryDAO;
import bookQueries.service.Dto.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookQueryServiceImpl implements IBookQueryService {

    @Autowired
    private BookQueryDAO bookQueryDAO;

    public BookDto getBook(long isbn){
        Optional<Book> book = bookQueryDAO.findById(isbn);
        if(book.isPresent()) {
            BookDto bookDTO = BookAdapter.getBookDtoFromBook(book.get());
            return bookDTO;
        } return new CustomMessage("Book with isbn : " + isbn + " is not available");

    }

    public BookDtos getBooks(){
        BookDtos bookDTOs = BookAdapter.getBookDtosFromBooks(bookQueryDAO.findAll());
        return bookDTOs;
    }
}
