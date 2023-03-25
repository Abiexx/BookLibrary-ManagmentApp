package reviewService.service;

import reviewService.service.Dto.ReviewDto;
import reviewService.service.Dto.ReviewsDto;

public interface ReviewService {
   public ReviewDto getReview(long reviewId);
    public ReviewsDto getReviews();
    public ReviewDto addReview(ReviewDto reviewDTO);
    public ReviewDto updateReview(long reviewId, ReviewDto reviewDTO);
    public ReviewDto deleteReview(long reviewId);
}
