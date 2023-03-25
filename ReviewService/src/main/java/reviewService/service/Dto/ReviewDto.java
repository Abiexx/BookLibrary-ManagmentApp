package reviewService.service.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDto {
    private long reviewId;
    private long isbn;
    private int reviewRating;
    private String customerName;
    private String description;
}
