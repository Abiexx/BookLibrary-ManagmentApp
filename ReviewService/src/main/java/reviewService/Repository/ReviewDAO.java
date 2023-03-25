package reviewService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reviewService.Domain.Review;

@Repository
public interface ReviewDAO extends MongoRepository<Review, Long> {

}
