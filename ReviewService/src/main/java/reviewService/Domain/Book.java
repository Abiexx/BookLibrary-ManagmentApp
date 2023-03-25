package reviewService.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private long isbn;
    private String title;
    private String description;
    private String authorName;
}
