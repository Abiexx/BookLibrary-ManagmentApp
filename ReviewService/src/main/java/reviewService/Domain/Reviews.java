package reviewService.Domain;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

public class Reviews {
    private List<Review> reviews;
}
