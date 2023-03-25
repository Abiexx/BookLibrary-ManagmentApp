package Book.service.adapter;

import Book.Domain.Customer;
import Book.service.Dto.CustomerDto;
import Book.service.Dto.CustomersDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter {



    public static Customer getCustomerFromCustomerDTO(CustomerDto customerDTO){
        return new Customer(customerDTO.getCustomerNumber(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getContact());
    }
    public static CustomerDto getCustomerDTOFromCustomer(Customer customer){
        return new CustomerDto(customer.getCustomerNumber(), customer.getName(), customer.getAddress(), customer.getContact());
    }

    public static CustomersDto getCustomersDTOFromCustomers(List<Customer> customers){
        List<CustomerDto> listCustomersDTO = new ArrayList<>();
        for(Customer cust: customers){
            listCustomersDTO.add(new CustomerDto(cust.getCustomerNumber(), cust.getName(), cust.getAddress(), cust.getContact()));
        }
        CustomersDto customersDTO = new CustomersDto(listCustomersDTO);
        return customersDTO;
    }


}
