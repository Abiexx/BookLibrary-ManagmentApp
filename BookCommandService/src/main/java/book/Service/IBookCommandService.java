package book.Service;


import book.Service.dto.BookDto;

public interface IBookCommandService {

    public BookDto addBook(BookDto bookDTO);
    public BookDto updateBook(long isbn, BookDto bookDTO);
    public BookDto deleteBook(long isbn);

}
