package borrowings.integration;

import borrowings.service.Dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "CustomerService")
public interface CustomerFeignClient {
    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable long customerNumber);
}
