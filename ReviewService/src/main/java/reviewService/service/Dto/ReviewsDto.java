package reviewService.service.Dto;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

public class ReviewsDto {
    private List<ReviewDto> reviewsDTO;
}
