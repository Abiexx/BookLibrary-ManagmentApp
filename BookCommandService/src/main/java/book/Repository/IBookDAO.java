package book.Repository;

import book.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDAO extends MongoRepository<Book, Long> {
}
