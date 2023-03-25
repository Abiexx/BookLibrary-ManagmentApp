package book.Controller;

import book.Service.IBookCommandService;
import book.Service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksCommandController {

       @Autowired
        private IBookCommandService iBookCommandService;

        @PostMapping
        public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        iBookCommandService.addBook(bookDto);
        return new ResponseEntity<>( bookDto, HttpStatus.OK);
    }
        @PutMapping("/{isbn}")
        public ResponseEntity<?> updateBook(@PathVariable long isbn, @RequestBody BookDto bookDto){
        iBookCommandService.updateBook(isbn,bookDto);
        return new ResponseEntity<>( bookDto, HttpStatus.OK);
    }


        @DeleteMapping("{isbn}")
        public ResponseEntity<?> deleteBook(@PathVariable long isbn){
        BookDto bookDto = iBookCommandService.deleteBook(isbn);
        return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }


}
