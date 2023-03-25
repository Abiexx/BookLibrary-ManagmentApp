package Book.service;

import Book.service.Dto.CustomerDto;
import Book.service.Dto.CustomersDto;

public interface CustomerService {

    public CustomerDto getCustomer(long customerNumber);
    public CustomersDto geCustomers();
    public CustomerDto addCustomer(CustomerDto customerDTO);
    public CustomerDto updateCustomer(long customerNumber, CustomerDto customerDTO);
    public CustomerDto deleteCustomer(long customerNumber);

}
