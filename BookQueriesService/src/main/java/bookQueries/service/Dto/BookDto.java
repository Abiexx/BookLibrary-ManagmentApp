package bookQueries.service.Dto;

import bookQueries.domain.Review;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter
@ToString
public class BookDto {
    private long isbn;
    private String title;
    private String description;
    private String author;
    private List<Review> reviews;
}
