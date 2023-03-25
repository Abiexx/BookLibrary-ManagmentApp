package reviewService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reviewService.Domain.Review;
import reviewService.Repository.ReviewDAO;
import reviewService.integration.KafkaSender;
import reviewService.service.adapter.ReviewAdapter;
import reviewService.service.Dto.ReviewDto;
import reviewService.service.Dto.ReviewsDto;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewDAO reviewDao;

    @Autowired
    KafkaSender kafkaSender;
    public ReviewDto getReview(long id){
        Review review = reviewDao.findById(id).get();
        ReviewDto reviewDTO = ReviewAdapter.getReviewDTOFromReview(review);
        return reviewDTO;
    }

    public ReviewsDto getReviews(){
        ReviewsDto reviewsDTO = ReviewAdapter.getReviewsDTOFromReviews(reviewDao.findAll());
        return reviewsDTO;
    }
    public ReviewDto addReview(ReviewDto reviewDTO){
        Review review = ReviewAdapter.getReviewFromReviewDTO(reviewDTO);
        reviewDao.save(review);
        kafkaSender.send("addreviewbooktopic", reviewDTO);
        return reviewDTO;
    }
    public ReviewDto updateReview(long id, ReviewDto reviewDTO){
        Review review = ReviewAdapter.getReviewFromReviewDTO(reviewDTO);
        reviewDao.save(review);
//        kafkaSender.send("updatereviewbooktopic", reviewDTO);
        return reviewDTO;
    }
    public ReviewDto deleteReview(long id){
        Review review = reviewDao.findById(id).get();
        ReviewDto reviewDTO = ReviewAdapter.getReviewDTOFromReview(review);
        reviewDao.deleteById(id);
//        kafkaSender.send("deletereviewbooktopic", reviewDTO);
        return reviewDTO;
    }
}
