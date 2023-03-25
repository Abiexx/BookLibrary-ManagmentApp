package reviewService.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Review {
    @Id
    private long reviewId;
    private long isbn;
    private int reviewRating;
    private String customerName;
    private String description;
}
