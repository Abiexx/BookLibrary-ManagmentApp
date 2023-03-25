package bookQueries.service.Dto;

import lombok.*;

import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ReviewsDto {
    List<ReviewDtO> reviewDtOS;
}
