//package reviewService.integration;
//
//import bookQueries.Repository.BookQueryDAO;
//import bookQueries.domain.Book;
//import bookQueries.service.BookQueryServiceImpl;
//import bookQueries.service.Dto.BookAdapter;
//import bookQueries.service.Dto.BookDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//import reviewService.Domain.Review;
//import reviewService.Repository.ReviewDAO;
//import reviewService.service.Dto.BookDto;
//import reviewService.service.ReviewService;
//
//@Service
//public class BookAddListener {
//    @Autowired
//    ReviewDAO reviewDAO;
//    @Autowired
//    ReviewService reviewService;
//
//
//    @KafkaListener(topics = {"addbooktopic"}, groupId = "gid")
//    public void receive(@Payload BookDto bookDTO) {
//        System.out.println("received message="+ bookDTO.getTitle());
//        Review review = new Review();
//
////        Book book = BookAdapter.getBookFromBookDto(bookDTO);
////        reviewDAO.save(book);
//    }
////    private long reviewId;
////    private long isbn;
////    private int reviewRating;
////    private String customerName;
////    private String description;
//
//}
