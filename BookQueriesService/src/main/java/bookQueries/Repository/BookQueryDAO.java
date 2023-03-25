package bookQueries.Repository;

import bookQueries.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookQueryDAO extends MongoRepository<Book, Long> {
}
