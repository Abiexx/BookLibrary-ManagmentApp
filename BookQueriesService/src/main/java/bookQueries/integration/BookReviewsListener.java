package bookQueries.integration;

import bookQueries.domain.Book;
import bookQueries.domain.Review;
import bookQueries.Repository.BookQueryDAO;
import bookQueries.service.BookQueryServiceImpl;
import bookQueries.service.Dto.ReviewAdapter;
import bookQueries.service.Dto.ReviewDtO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BookReviewsListener {
    @Autowired
    BookQueryDAO bookQueryDAO;
    @Autowired
    BookQueryServiceImpl bookService;


    @KafkaListener(topics = {"addreviewbooktopic"}, groupId = "gid1")
    public void receiveAdd(@Payload String reviewDtoString) {
        ObjectMapper objectMapper = new ObjectMapper();
        ReviewDtO reviewDto;
        try {
            reviewDto = objectMapper.readValue(reviewDtoString , ReviewDtO.class);
            Book book = bookQueryDAO.findById(reviewDto.getIsbn()).get();
            Review review = ReviewAdapter.getReviewFromReviewDto(reviewDto);
            book.addReviews(review);
            System.out.println("reviews --------------------------"+review);
            bookQueryDAO.save(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    }

//    @KafkaListener(topics = {"updatereviewbooktopic"}, groupId = "gid2")
//    public void receiveUpdate(@Payload ReviewDto reviewDTO) {
////        System.out.println("received review message="+ reviewDTO.getCustomerName());
//
//        Book book = bookQueryDAO.findById(reviewDTO.getIsbn()).get();
//        Review review = ReviewAdapter.getReviewFromReviewDto(reviewDTO);
//        book.addReviews(review);
//        System.out.println("reviews --------------------------"+review);
//        bookQueryDAO.save(book);
//    }

//    @KafkaListener(topics = {"deletereviewbooktopic"}, groupId = "gid1")
//    public void receiveDelete(@Payload ReviewDto reviewDTO) {
////        System.out.println("received review message="+ reviewDTO.getCustomerName());
//
//        Book book = bookQueryDAO.findById(reviewDTO.getIsbn()).get();
//        Review review = ReviewAdapter.getReviewFromReviewDto(reviewDTO);
//        for(Review rev : book.getReviews()){
//            if(rev.getReviewId()==review.getReviewId()) book.setReviews(null);
//        }
//        bookQueryDAO.save(book);
//    }
//}
