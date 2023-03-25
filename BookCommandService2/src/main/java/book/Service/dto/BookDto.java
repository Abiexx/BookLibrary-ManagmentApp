package book.Service.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {
    private long isbn;
    private String title;
    private String description;
    private String author;
}
