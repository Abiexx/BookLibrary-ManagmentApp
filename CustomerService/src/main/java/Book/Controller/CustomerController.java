package Book.Controller;

import Book.service.CustomerService;
import Book.service.Dto.CustomerDto;
import Book.service.Dto.CustomersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable long customerNumber){
        CustomerDto customerDTO = customerService.getCustomer(customerNumber);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<CustomersDto> getCustomers(){
        CustomersDto customersDTO = customerService.geCustomers();
        return new ResponseEntity<>(customersDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDTO){

        CustomerDto customerDT = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customerDT, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable long id, @RequestBody CustomerDto customerDTO){
        customerService.updateCustomer(id, customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable long id){
        CustomerDto customerDTO = customerService.deleteCustomer(id);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
}
