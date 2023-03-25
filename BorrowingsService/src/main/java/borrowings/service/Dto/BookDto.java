package borrowings.service.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {


    private long isbn;
    private String title;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String author;


}
