package reviewService.service.adapter;


import reviewService.Domain.Review;
import reviewService.service.Dto.ReviewDto;
import reviewService.service.Dto.ReviewsDto;


import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter {

    public static Review getReviewFromReviewDTO(ReviewDto reviewDTO){
        return new Review(reviewDTO.getReviewId(), reviewDTO.getIsbn(), reviewDTO.getReviewRating(), reviewDTO.getCustomerName(), reviewDTO.getDescription());
    }

    public static ReviewDto getReviewDTOFromReview(Review review){
        return new ReviewDto(review.getReviewId(), review.getIsbn(), review.getReviewRating(), review.getCustomerName(), review.getDescription());
    }

    public static ReviewsDto getReviewsDTOFromReviews(List<Review> reviews){
        List<ReviewDto> listReviewsDTO = new ArrayList<>();
        for(Review review: reviews){
            listReviewsDTO.add(new ReviewDto(review.getReviewId(), review.getIsbn(), review.getReviewRating(), review.getCustomerName(), review.getDescription()));
        }
        ReviewsDto reviewsDTO = new ReviewsDto(listReviewsDTO);
        return reviewsDTO;
    }
}
