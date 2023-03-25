package Book.Repository;

import Book.Domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends MongoRepository<Customer, Long> {
}
