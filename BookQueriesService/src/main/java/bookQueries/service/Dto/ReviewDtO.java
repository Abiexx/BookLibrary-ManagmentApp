package bookQueries.service.Dto;

import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter
@ToString
public class ReviewDtO {
    @Id
    private long reviewId;
    private long isbn;
    private int reviewRating;
    private String customerName;
    private String description;
}
