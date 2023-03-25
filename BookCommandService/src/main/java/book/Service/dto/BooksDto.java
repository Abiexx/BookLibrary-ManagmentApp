package book.Service.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BooksDto {
    private List<BookDto> bookDtos;
}
