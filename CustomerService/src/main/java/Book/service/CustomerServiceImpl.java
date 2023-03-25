package Book.service;



import Book.Domain.Customer;
import Book.Repository.CustomerDAO;
import Book.integration.KafkaSender;
import Book.service.adapter.CustomerAdapter;
import Book.service.Dto.CustomerDto;
import Book.service.Dto.CustomersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    KafkaSender kafkaSender;
    public CustomerDto getCustomer(long customerNumber){
        Customer customer = customerDao.findById(customerNumber).get();
        CustomerDto customerDTO = CustomerAdapter.getCustomerDTOFromCustomer(customer);
        return customerDTO;
    }

    public CustomersDto geCustomers(){
        CustomersDto customersDTO = CustomerAdapter.getCustomersDTOFromCustomers(customerDao.findAll());
        return customersDTO;
    }
    public CustomerDto addCustomer(CustomerDto customerDTO){
        Customer customer = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
        customerDao.save(customer);
        return customerDTO;
    }
    public CustomerDto updateCustomer(long customerNumber, CustomerDto customerDTO){
        Customer customer = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
        customerDao.save(customer);
        kafkaSender.send("updateCustomertopic",customerDTO);
//        kafkaSender.sendToBorrowing("updateBorrowingtopic",customerDTO);
        return customerDTO;
    }
    public CustomerDto deleteCustomer(long customerNumber){
        Customer customer = customerDao.findById(customerNumber).get();
        CustomerDto customerDTO = CustomerAdapter.getCustomerDTOFromCustomer(customer);
        customerDao.deleteById(customerNumber);
        return customerDTO;
    }
}
