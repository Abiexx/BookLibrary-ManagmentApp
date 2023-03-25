package bookQueries.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    private long isbn;
    private String title;
    private String description;
    private String author;
    private List<Review> reviews = new ArrayList<>();

    public void addReviews(Review review){
        reviews.add(review);
    }
}
