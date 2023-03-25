package borrowings.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import borrowings.Domain.Borrowing;
import borrowings.Repository.BorrowingDAO;
import borrowings.service.Dto.BorrowingDto;
import borrowings.service.Dto.CustomMessage;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BorrowingsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BorrowingsServiceImplTest {
    @MockBean
    private BorrowingDAO borrowingDAO;

    @Autowired
    private BorrowingsServiceImpl borrowingsServiceImpl;

    /**
     * Method under test: {@link BorrowingsServiceImpl#getBorrowing(long)}
     */
    @Test
    void testGetBorrowing() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        BorrowingDto actualBorrowing = borrowingsServiceImpl.getBorrowing(1L);
        assertEquals("Dr", actualBorrowing.getBookTitle());
        assertEquals(1L, actualBorrowing.getIsbn());
        assertEquals("2020-03-01", actualBorrowing.getDate());
        assertEquals(1L, actualBorrowing.getCustomerNumber());
        assertEquals("Customer Name", actualBorrowing.getCustomerName());
        assertEquals(1L, actualBorrowing.getBorrowingNumber());
        verify(borrowingDAO).findById((Long) any());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#getBorrowing(long)}
     */
    @Test
    void testGetBorrowing2() {
        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        BorrowingDto actualBorrowing = borrowingsServiceImpl.getBorrowing(1L);
        assertEquals("Dr", actualBorrowing.getBookTitle());
        assertEquals(1L, actualBorrowing.getIsbn());
        assertEquals("2020-03-01", actualBorrowing.getDate());
        assertEquals(1L, actualBorrowing.getCustomerNumber());
        assertEquals("Customer Name", actualBorrowing.getCustomerName());
        assertEquals(1L, actualBorrowing.getBorrowingNumber());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowing).getBookTitle();
        verify(borrowing).getCustomerName();
        verify(borrowing).getDate();
        verify(borrowing).getBorrowingNumber();
        verify(borrowing).getCustomerNumber();
        verify(borrowing).getIsbn();
        verify(borrowing).setBookTitle((String) any());
        verify(borrowing).setBorrowingNumber(anyLong());
        verify(borrowing).setCustomerName((String) any());
        verify(borrowing).setCustomerNumber(anyLong());
        verify(borrowing).setDate((String) any());
        verify(borrowing).setIsbn(anyLong());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#getBorrowing(long)}
     */
    @Test
    void testGetBorrowing3() {
        when(borrowingDAO.findById((Long) any())).thenReturn(Optional.empty());
        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        assertEquals("Borrowing with 1 not available",
                ((CustomMessage) borrowingsServiceImpl.getBorrowing(1L)).getMessage());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowing).setBookTitle((String) any());
        verify(borrowing).setBorrowingNumber(anyLong());
        verify(borrowing).setCustomerName((String) any());
        verify(borrowing).setCustomerNumber(anyLong());
        verify(borrowing).setDate((String) any());
        verify(borrowing).setIsbn(anyLong());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#getBorrowings()}
     */
    @Test
    void testGetBorrowings() {
        ArrayList<Borrowing> borrowingList = new ArrayList<>();
        when(borrowingDAO.findAll()).thenReturn(borrowingList);
        assertEquals(borrowingList, borrowingsServiceImpl.getBorrowings().getBorrowingsDTO());
        verify(borrowingDAO).findAll();
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#getBorrowings()}
     */
    @Test
    void testGetBorrowings2() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);

        ArrayList<Borrowing> borrowingList = new ArrayList<>();
        borrowingList.add(borrowing);
        when(borrowingDAO.findAll()).thenReturn(borrowingList);
        assertEquals(1, borrowingsServiceImpl.getBorrowings().getBorrowingsDTO().size());
        verify(borrowingDAO).findAll();
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#getBorrowings()}
     */
    @Test
    void testGetBorrowings3() {
        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);

        ArrayList<Borrowing> borrowingList = new ArrayList<>();
        borrowingList.add(borrowing);
        when(borrowingDAO.findAll()).thenReturn(borrowingList);
        assertEquals(1, borrowingsServiceImpl.getBorrowings().getBorrowingsDTO().size());
        verify(borrowingDAO).findAll();
        verify(borrowing).getBookTitle();
        verify(borrowing).getCustomerName();
        verify(borrowing).getDate();
        verify(borrowing).getBorrowingNumber();
        verify(borrowing).getCustomerNumber();
        verify(borrowing).getIsbn();
        verify(borrowing).setBookTitle((String) any());
        verify(borrowing).setBorrowingNumber(anyLong());
        verify(borrowing).setCustomerName((String) any());
        verify(borrowing).setCustomerNumber(anyLong());
        verify(borrowing).setDate((String) any());
        verify(borrowing).setIsbn(anyLong());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#addBorrowing(BorrowingDto)}
     */
    @Test
    void testAddBorrowing() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing);
        BorrowingDto borrowingDto = new BorrowingDto(1L, "2020-03-01", 1L, "Customer Name", 1L, "Dr");

        assertSame(borrowingDto, borrowingsServiceImpl.addBorrowing(borrowingDto));
        verify(borrowingDAO).save((Borrowing) any());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#addBorrowing(BorrowingDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddBorrowing2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at borrowings.service.adapter.BorrowingsAdapter.getBorrowingFromBorrowingDTO(BorrowingsAdapter.java:15)
        //       at borrowings.service.BorrowingsServiceImpl.addBorrowing(BorrowingsServiceImpl.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing);
        borrowingsServiceImpl.addBorrowing(null);
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#addBorrowing(BorrowingDto)}
     */
    @Test
    void testAddBorrowing3() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing);
        BorrowingDto borrowingDto = mock(BorrowingDto.class);
        when(borrowingDto.getBookTitle()).thenReturn("Dr");
        when(borrowingDto.getCustomerName()).thenReturn("Customer Name");
        when(borrowingDto.getDate()).thenReturn("2020-03-01");
        when(borrowingDto.getBorrowingNumber()).thenReturn(1L);
        when(borrowingDto.getCustomerNumber()).thenReturn(1L);
        when(borrowingDto.getIsbn()).thenReturn(1L);
        borrowingsServiceImpl.addBorrowing(borrowingDto);
        verify(borrowingDAO).save((Borrowing) any());
        verify(borrowingDto).getBookTitle();
        verify(borrowingDto).getCustomerName();
        verify(borrowingDto).getDate();
        verify(borrowingDto).getBorrowingNumber();
        verify(borrowingDto).getCustomerNumber();
        verify(borrowingDto).getIsbn();
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#updateBorrowing(long, BorrowingDto)}
     */
    @Test
    void testUpdateBorrowing() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setBookTitle("Dr");
        borrowing1.setBorrowingNumber(1L);
        borrowing1.setCustomerName("Customer Name");
        borrowing1.setCustomerNumber(1L);
        borrowing1.setDate("2020-03-01");
        borrowing1.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing1);
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        BorrowingDto actualUpdateBorrowingResult = borrowingsServiceImpl.updateBorrowing(1L,
                new BorrowingDto(1L, "2020-03-01", 1L, "Customer Name", 1L, "Dr"));
        assertEquals("Dr", actualUpdateBorrowingResult.getBookTitle());
        assertEquals(1L, actualUpdateBorrowingResult.getIsbn());
        assertEquals("2020-03-01", actualUpdateBorrowingResult.getDate());
        assertEquals(1L, actualUpdateBorrowingResult.getCustomerNumber());
        assertEquals("Customer Name", actualUpdateBorrowingResult.getCustomerName());
        assertEquals(1L, actualUpdateBorrowingResult.getBorrowingNumber());
        verify(borrowingDAO).save((Borrowing) any());
        verify(borrowingDAO).findById((Long) any());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#updateBorrowing(long, BorrowingDto)}
     */
    @Test
    void testUpdateBorrowing2() {
        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setBookTitle("Dr");
        borrowing1.setBorrowingNumber(1L);
        borrowing1.setCustomerName("Customer Name");
        borrowing1.setCustomerNumber(1L);
        borrowing1.setDate("2020-03-01");
        borrowing1.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing1);
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        BorrowingDto actualUpdateBorrowingResult = borrowingsServiceImpl.updateBorrowing(1L,
                new BorrowingDto(1L, "2020-03-01", 1L, "Customer Name", 1L, "Dr"));
        assertEquals("Dr", actualUpdateBorrowingResult.getBookTitle());
        assertEquals(1L, actualUpdateBorrowingResult.getIsbn());
        assertEquals("2020-03-01", actualUpdateBorrowingResult.getDate());
        assertEquals(1L, actualUpdateBorrowingResult.getCustomerNumber());
        assertEquals("Customer Name", actualUpdateBorrowingResult.getCustomerName());
        assertEquals(1L, actualUpdateBorrowingResult.getBorrowingNumber());
        verify(borrowingDAO).save((Borrowing) any());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowing).getBookTitle();
        verify(borrowing).getCustomerName();
        verify(borrowing).getDate();
        verify(borrowing).getBorrowingNumber();
        verify(borrowing).getCustomerNumber();
        verify(borrowing).getIsbn();
        verify(borrowing, atLeast(1)).setBookTitle((String) any());
        verify(borrowing, atLeast(1)).setBorrowingNumber(anyLong());
        verify(borrowing, atLeast(1)).setCustomerName((String) any());
        verify(borrowing, atLeast(1)).setCustomerNumber(anyLong());
        verify(borrowing, atLeast(1)).setDate((String) any());
        verify(borrowing, atLeast(1)).setIsbn(anyLong());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#updateBorrowing(long, BorrowingDto)}
     */
    @Test
    void testUpdateBorrowing3() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing);
        when(borrowingDAO.findById((Long) any())).thenReturn(Optional.empty());
        Borrowing borrowing1 = mock(Borrowing.class);
        when(borrowing1.getBookTitle()).thenReturn("Dr");
        when(borrowing1.getCustomerName()).thenReturn("Customer Name");
        when(borrowing1.getDate()).thenReturn("2020-03-01");
        when(borrowing1.getBorrowingNumber()).thenReturn(1L);
        when(borrowing1.getCustomerNumber()).thenReturn(1L);
        when(borrowing1.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing1).setBookTitle((String) any());
        doNothing().when(borrowing1).setBorrowingNumber(anyLong());
        doNothing().when(borrowing1).setCustomerName((String) any());
        doNothing().when(borrowing1).setCustomerNumber(anyLong());
        doNothing().when(borrowing1).setDate((String) any());
        doNothing().when(borrowing1).setIsbn(anyLong());
        borrowing1.setBookTitle("Dr");
        borrowing1.setBorrowingNumber(1L);
        borrowing1.setCustomerName("Customer Name");
        borrowing1.setCustomerNumber(1L);
        borrowing1.setDate("2020-03-01");
        borrowing1.setIsbn(1L);
        assertEquals("Borrowing with 1 Is not available for update", ((CustomMessage) borrowingsServiceImpl
                .updateBorrowing(1L, new BorrowingDto(1L, "2020-03-01", 1L, "Customer Name", 1L, "Dr"))).getMessage());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowing1).setBookTitle((String) any());
        verify(borrowing1).setBorrowingNumber(anyLong());
        verify(borrowing1).setCustomerName((String) any());
        verify(borrowing1).setCustomerNumber(anyLong());
        verify(borrowing1).setDate((String) any());
        verify(borrowing1).setIsbn(anyLong());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#updateBorrowing(long, BorrowingDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateBorrowing4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at borrowings.service.BorrowingsServiceImpl.updateBorrowing(BorrowingsServiceImpl.java:49)
        //   See https://diff.blue/R013 to resolve this issue.

        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setBookTitle("Dr");
        borrowing1.setBorrowingNumber(1L);
        borrowing1.setCustomerName("Customer Name");
        borrowing1.setCustomerNumber(1L);
        borrowing1.setDate("2020-03-01");
        borrowing1.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing1);
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        borrowingsServiceImpl.updateBorrowing(1L, null);
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#updateBorrowing(long, BorrowingDto)}
     */
    @Test
    void testUpdateBorrowing5() {
        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setBookTitle("Dr");
        borrowing1.setBorrowingNumber(1L);
        borrowing1.setCustomerName("Customer Name");
        borrowing1.setCustomerNumber(1L);
        borrowing1.setDate("2020-03-01");
        borrowing1.setIsbn(1L);
        when(borrowingDAO.save((Borrowing) any())).thenReturn(borrowing1);
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        BorrowingDto borrowingDto = mock(BorrowingDto.class);
        when(borrowingDto.getBookTitle()).thenReturn("Dr");
        when(borrowingDto.getCustomerName()).thenReturn("Customer Name");
        when(borrowingDto.getDate()).thenReturn("2020-03-01");
        when(borrowingDto.getBorrowingNumber()).thenReturn(1L);
        when(borrowingDto.getCustomerNumber()).thenReturn(1L);
        when(borrowingDto.getIsbn()).thenReturn(1L);
        BorrowingDto actualUpdateBorrowingResult = borrowingsServiceImpl.updateBorrowing(1L, borrowingDto);
        assertEquals("Dr", actualUpdateBorrowingResult.getBookTitle());
        assertEquals(1L, actualUpdateBorrowingResult.getIsbn());
        assertEquals("2020-03-01", actualUpdateBorrowingResult.getDate());
        assertEquals(1L, actualUpdateBorrowingResult.getCustomerNumber());
        assertEquals("Customer Name", actualUpdateBorrowingResult.getCustomerName());
        assertEquals(1L, actualUpdateBorrowingResult.getBorrowingNumber());
        verify(borrowingDAO).save((Borrowing) any());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowing).getBookTitle();
        verify(borrowing).getCustomerName();
        verify(borrowing).getDate();
        verify(borrowing).getBorrowingNumber();
        verify(borrowing).getCustomerNumber();
        verify(borrowing).getIsbn();
        verify(borrowing, atLeast(1)).setBookTitle((String) any());
        verify(borrowing, atLeast(1)).setBorrowingNumber(anyLong());
        verify(borrowing, atLeast(1)).setCustomerName((String) any());
        verify(borrowing, atLeast(1)).setCustomerNumber(anyLong());
        verify(borrowing, atLeast(1)).setDate((String) any());
        verify(borrowing, atLeast(1)).setIsbn(anyLong());
        verify(borrowingDto).getBookTitle();
        verify(borrowingDto).getCustomerName();
        verify(borrowingDto).getDate();
        verify(borrowingDto).getBorrowingNumber();
        verify(borrowingDto).getCustomerNumber();
        verify(borrowingDto).getIsbn();
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#deleteBorrowing(long)}
     */
    @Test
    void testDeleteBorrowing() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);
        doNothing().when(borrowingDAO).deleteById((Long) any());
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        BorrowingDto actualDeleteBorrowingResult = borrowingsServiceImpl.deleteBorrowing(1L);
        assertEquals("Dr", actualDeleteBorrowingResult.getBookTitle());
        assertEquals(1L, actualDeleteBorrowingResult.getIsbn());
        assertEquals("2020-03-01", actualDeleteBorrowingResult.getDate());
        assertEquals(1L, actualDeleteBorrowingResult.getCustomerNumber());
        assertEquals("Customer Name", actualDeleteBorrowingResult.getCustomerName());
        assertEquals(1L, actualDeleteBorrowingResult.getBorrowingNumber());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowingDAO).deleteById((Long) any());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#deleteBorrowing(long)}
     */
    @Test
    void testDeleteBorrowing2() {
        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        Optional<Borrowing> ofResult = Optional.of(borrowing);
        doNothing().when(borrowingDAO).deleteById((Long) any());
        when(borrowingDAO.findById((Long) any())).thenReturn(ofResult);
        BorrowingDto actualDeleteBorrowingResult = borrowingsServiceImpl.deleteBorrowing(1L);
        assertEquals("Dr", actualDeleteBorrowingResult.getBookTitle());
        assertEquals(1L, actualDeleteBorrowingResult.getIsbn());
        assertEquals("2020-03-01", actualDeleteBorrowingResult.getDate());
        assertEquals(1L, actualDeleteBorrowingResult.getCustomerNumber());
        assertEquals("Customer Name", actualDeleteBorrowingResult.getCustomerName());
        assertEquals(1L, actualDeleteBorrowingResult.getBorrowingNumber());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowingDAO).deleteById((Long) any());
        verify(borrowing).getBookTitle();
        verify(borrowing).getCustomerName();
        verify(borrowing).getDate();
        verify(borrowing).getBorrowingNumber();
        verify(borrowing).getCustomerNumber();
        verify(borrowing).getIsbn();
        verify(borrowing).setBookTitle((String) any());
        verify(borrowing).setBorrowingNumber(anyLong());
        verify(borrowing).setCustomerName((String) any());
        verify(borrowing).setCustomerNumber(anyLong());
        verify(borrowing).setDate((String) any());
        verify(borrowing).setIsbn(anyLong());
    }

    /**
     * Method under test: {@link BorrowingsServiceImpl#deleteBorrowing(long)}
     */
    @Test
    void testDeleteBorrowing3() {
        doNothing().when(borrowingDAO).deleteById((Long) any());
        when(borrowingDAO.findById((Long) any())).thenReturn(Optional.empty());
        Borrowing borrowing = mock(Borrowing.class);
        when(borrowing.getBookTitle()).thenReturn("Dr");
        when(borrowing.getCustomerName()).thenReturn("Customer Name");
        when(borrowing.getDate()).thenReturn("2020-03-01");
        when(borrowing.getBorrowingNumber()).thenReturn(1L);
        when(borrowing.getCustomerNumber()).thenReturn(1L);
        when(borrowing.getIsbn()).thenReturn(1L);
        doNothing().when(borrowing).setBookTitle((String) any());
        doNothing().when(borrowing).setBorrowingNumber(anyLong());
        doNothing().when(borrowing).setCustomerName((String) any());
        doNothing().when(borrowing).setCustomerNumber(anyLong());
        doNothing().when(borrowing).setDate((String) any());
        doNothing().when(borrowing).setIsbn(anyLong());
        borrowing.setBookTitle("Dr");
        borrowing.setBorrowingNumber(1L);
        borrowing.setCustomerName("Customer Name");
        borrowing.setCustomerNumber(1L);
        borrowing.setDate("2020-03-01");
        borrowing.setIsbn(1L);
        assertEquals("Borrowing with 1 Is not available for deletion",
                ((CustomMessage) borrowingsServiceImpl.deleteBorrowing(1L)).getMessage());
        verify(borrowingDAO).findById((Long) any());
        verify(borrowing).setBookTitle((String) any());
        verify(borrowing).setBorrowingNumber(anyLong());
        verify(borrowing).setCustomerName((String) any());
        verify(borrowing).setCustomerNumber(anyLong());
        verify(borrowing).setDate((String) any());
        verify(borrowing).setIsbn(anyLong());
    }
}

