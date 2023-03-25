package borrowings.Domain;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private long customerNumber;
    private String name;
//    private Address address;
//    private Contact contact;

}
