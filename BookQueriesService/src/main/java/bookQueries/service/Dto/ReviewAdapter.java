package bookQueries.service.Dto;

import bookQueries.domain.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter {
    public static Review getReviewFromReviewDto(ReviewDtO reviewDTO){
        return new Review(reviewDTO.getReviewId(), reviewDTO.getIsbn(), reviewDTO.getReviewRating(),reviewDTO.getCustomerName(), reviewDTO.getDescription());
    }
    public static ReviewDtO getReviewDtoFromReview(Review review){
        return new ReviewDtO(review.getReviewId(), review.getIsbn(), review.getReviewRating(), review.getCustomerName(), review.getDescription());
    }
    public static ReviewsDto getReviewDtosFromReviews(List<Review> reviews){
        List<ReviewDtO> listReviewsDTO = new ArrayList<>();
        for(Review review: reviews){
            listReviewsDTO.add(new ReviewDtO(review.getReviewId(), review.getIsbn(), review.getReviewRating(), review.getCustomerName(), review.getDescription()));
        }
        ReviewsDto reviewsDto = new ReviewsDto(listReviewsDTO);
        return reviewsDto;
    }
}
