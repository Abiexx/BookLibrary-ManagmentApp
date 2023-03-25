package bookQueries.Controller;

import bookQueries.service.IBookQueryService;
import bookQueries.service.Dto.BookDto;
import bookQueries.service.Dto.BookDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookQueryController {

    @Autowired
    private IBookQueryService IBookQueryService;

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable long isbn){
        BookDto bookDTO = IBookQueryService.getBook(isbn);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<BookDtos> getBooks(){
        BookDtos bookDTOs = IBookQueryService.getBooks();
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

}
