package borrowings.Repository;

import borrowings.Domain.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowingDAO extends MongoRepository<Borrowing, Long> {

    @Query("{'customer.customerNumber'::#{#customerNumber}}")
    List<Borrowing> findCBorrowingsByCustomerNumber(@Param("customerNumber") long customerNumber);


    @Query("{'book.isbn'::#{#isbn}}")
    List<Borrowing> findBorrowingsByIsbn(@Param("isbn") long isbn);
}
