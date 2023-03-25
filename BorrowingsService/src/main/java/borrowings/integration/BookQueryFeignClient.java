package borrowings.integration;


import borrowings.service.Dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "BookQueriesService")
public interface BookQueryFeignClient {
    @GetMapping("/books/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable long isbn);
}
