package Book.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Customer {
    @Id
    private long customerNumber;
    private String name;
    private Address address;
    private Contact contact;

}
