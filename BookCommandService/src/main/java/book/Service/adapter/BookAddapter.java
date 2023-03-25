package book.Service.adapter;

import book.Service.dto.BookDto;
import book.Service.dto.BooksDto;
import book.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAddapter {

    public static Book getBookFromBookDTO(BookDto bookDTO){
        return new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getAuthor());
    }
    public static BookDto getBookDTOFromBook(Book book){
        return new BookDto(book.getIsbn(), book.getTitle(), book.getDescription(), book.getAuthor());
    }

    public static BooksDto getBooksDTOFromBooks(List<Book> books){
        List<BookDto> listBookDtos = new ArrayList<>();
        for(Book book: books){
            listBookDtos.add(new BookDto(book.getIsbn(),book.getTitle(),book.getDescription(),book.getAuthor()));
        }
        BooksDto booksDto = new BooksDto(listBookDtos);
        return booksDto;
    }


}
