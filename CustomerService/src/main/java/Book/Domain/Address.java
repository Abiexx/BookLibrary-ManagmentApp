package Book.Domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {

    private String street;
    private String zip;
    private String city;
    private String state;
}
