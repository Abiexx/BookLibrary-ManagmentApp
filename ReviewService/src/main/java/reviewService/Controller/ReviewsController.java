package reviewService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reviewService.service.Dto.ReviewDto;
import reviewService.service.Dto.ReviewsDto;
import reviewService.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable long id){
        ReviewDto reviewDTO = reviewService.getReview(id);
        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<ReviewsDto> getReviews(){
        ReviewsDto reviewsDTO = reviewService.getReviews();
        return new ResponseEntity<>(reviewsDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDTO){
        reviewService.addReview(reviewDTO);
        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable long id, @RequestBody ReviewDto reviewDTO){
        reviewService.updateReview(id, reviewDTO);
        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDto> deleteReview(@PathVariable long id){

        ReviewDto reviewDTO = reviewService.deleteReview(id);

        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }

}
