package borrowings.service;


import borrowings.service.Dto.BorrowingDto;
import borrowings.service.Dto.BorrowingsDto;

public interface BorrowingsService {

    public BorrowingDto getBorrowing(long borrowingNumber);

    public BorrowingsDto getBorrowings();

    public BorrowingDto addBorrowing( long customerNumber,long isbn, BorrowingDto borrowingDto);

    public BorrowingDto updateBorrowing(long borrowingNumber, BorrowingDto borrowingDto); // Miki


    public BorrowingDto deleteBorrowing(long borrowingNumber);



}
