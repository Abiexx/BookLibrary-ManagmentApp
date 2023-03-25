package borrowings.service.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.tomcat.jni.Address;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerDto {

    private long customerNumber;
    private String name;
    @JsonIgnore
    private Address address;
    @JsonIgnore
    private ContactDto contact;

}
