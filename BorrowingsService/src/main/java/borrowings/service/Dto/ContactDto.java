package borrowings.service.Dto;//package borrowings.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ContactDto {
@JsonIgnore
    private String phoneNumber;
@JsonIgnore
    private String email;
}
