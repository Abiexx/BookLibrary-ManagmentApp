package borrowings.service;

import borrowings.Domain.Borrowing;
import borrowings.Repository.BorrowingDAO;
import borrowings.integration.BookQueryFeignClient;
import borrowings.integration.CustomerFeignClient;
import borrowings.service.Dto.*;
import borrowings.service.adapter.BorrowingsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowingsServiceImpl implements BorrowingsService{

    @Autowired
    private  BorrowingDAO borrowingDAO;

    @Autowired
    private CustomerFeignClient customerFeignClient;

    @Autowired
    private BookQueryFeignClient bookQueryFeignClient;

    @Override
    public BorrowingDto getBorrowing(long borrowingNumber) {
        Optional<Borrowing> borrowing = borrowingDAO.findById(borrowingNumber);
        if (borrowing.isPresent()){
            BorrowingDto borrowingDto = BorrowingsAdapter.getBorrowingDTOFromBorrowing(borrowing.get());
            return borrowingDto;
        }
        return new CustomMessage("Borrowing with " + borrowingNumber + " not available");
    }

    @Override
    public BorrowingsDto getBorrowings() {
        //  List<Borrowing> borrowings = borrowingDAO.findAll();
        BorrowingsDto borrowingDtos  =  BorrowingsAdapter.getBorrowingsDTOFromBorrowings(borrowingDAO.findAll());
        return borrowingDtos;
    }

    @Override
    public BorrowingDto addBorrowing( long customerNumber, long isbn, BorrowingDto borrowingDto) {
       BookDto bookDto = bookQueryFeignClient.getBook(isbn).getBody();
        System.out.println("book ===" +bookDto.toString());
       CustomerDto customerDto = customerFeignClient.getCustomer(customerNumber).getBody();
        System.out.println("customer ===" +customerDto.toString());
        Borrowing borrowing = BorrowingsAdapter.createBorrowing(customerDto, bookDto, borrowingDto);
        borrowingDAO.save(borrowing);
        BorrowingDto borrowingDto1 = BorrowingsAdapter.getBorrowingDTOFromBorrowing(borrowing);
        return  borrowingDto1;
    }

    @Override
    public BorrowingDto updateBorrowing(long borrowingNumber, BorrowingDto borrowingDto) {
        Optional<Borrowing> borrowing = borrowingDAO.findById(borrowingNumber);
        if (borrowing.isPresent()){
            Borrowing borrowing1 = borrowing.get();
            borrowing1.setBorrowingNumber(borrowingDto.getBorrowingNumber());
            borrowing1.setDate(borrowingDto.getDate());
            borrowing1.setCustomer(borrowingDto.getCustmomer());
            borrowing1.setBook(borrowingDto.getBook());
//            borrowing1.setCustomerNumber(borrowingDto.getCustomerNumber());
//            borrowing1.setCustomerName(borrowingDto.getCustomerName());
//            borrowing1.setIsbn(borrowingDto.getIsbn());
//            borrowing1.setBookTitle(borrowingDto.getBookTitle());
            borrowingDAO.save(borrowing1);
            return BorrowingsAdapter.getBorrowingDTOFromBorrowing(borrowing1);
        }


        return new CustomMessage("Borrowing with " + borrowingNumber + " Is not available for update");
    }

    @Override
    public BorrowingDto deleteBorrowing(long borrowingNumber) {
        Optional<Borrowing> borrowing = borrowingDAO.findById(borrowingNumber);
        if (borrowing.isPresent()) {
            BorrowingDto borrowingDTO = BorrowingsAdapter.getBorrowingDTOFromBorrowing(borrowing.get());
            borrowingDAO.deleteById(borrowingNumber);
            return borrowingDTO;
        }
        return new CustomMessage("Borrowing with " + borrowingNumber + " Is not available for deletion");

    }
}
