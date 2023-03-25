package Book.service.Dto;

import Book.Domain.Address;
import Book.Domain.Contact;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Document
public class CustomerDto {
    @Id
    private long customerNumber;
    private String name;
    private Address address;
    private Contact contact;

    CustomerDto(long customerNumber,String name){
        this.customerNumber =customerNumber;
        this.name= name;
    }
}
