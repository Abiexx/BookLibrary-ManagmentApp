package Book.Domain;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Customers {
    private List<Customer> customers;
}
