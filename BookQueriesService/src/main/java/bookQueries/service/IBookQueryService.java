package bookQueries.service;


import bookQueries.service.Dto.BookDto;
import bookQueries.service.Dto.BookDtos;


public interface IBookQueryService {
    public BookDto getBook(long isbn);
    public BookDtos getBooks();

}
