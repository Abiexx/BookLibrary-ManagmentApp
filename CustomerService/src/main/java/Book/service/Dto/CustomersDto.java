package Book.service.Dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CustomersDto {
    private List<CustomerDto> customersDTO;


}
