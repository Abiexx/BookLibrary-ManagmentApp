package reviewService.Domain;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Books {
    private List<Book> books;
}
