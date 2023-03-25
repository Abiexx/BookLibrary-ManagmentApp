package book.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import book.Repository.IBookDAO;
import book.Service.dto.BookDto;
import book.domain.Book;
import book.integration.KafkaSender;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BookCommandServiceImp.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookCommandServiceImpTest {
    @Autowired
    private BookCommandServiceImp bookCommandServiceImp;

    @MockBean
    private IBookDAO iBookDAO;

    @MockBean
    private KafkaSender kafkaSender;

    /**
     * Method under test: {@link BookCommandServiceImp#addBook(BookDto)}
     */
    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        when(iBookDAO.save((Book) any())).thenReturn(book);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        BookDto bookDto = new BookDto(1L, "Dr", "The characteristics of someone or something", "JaneDoe");

        assertSame(bookDto, bookCommandServiceImp.addBook(bookDto));
        verify(iBookDAO).save((Book) any());
        verify(kafkaSender).send((String) any(), (BookDto) any());
    }

    /**
     * Method under test: {@link BookCommandServiceImp#addBook(BookDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAddBook2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at book.Service.adapter.BookAddapter.getBookFromBookDTO(BookAddapter.java:11)
        //       at book.Service.BookCommandServiceImp.addBook(BookCommandServiceImp.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        when(iBookDAO.save((Book) any())).thenReturn(book);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        bookCommandServiceImp.addBook(null);
    }

    /**
     * Method under test: {@link BookCommandServiceImp#addBook(BookDto)}
     */
    @Test
    public void testAddBook3() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        when(iBookDAO.save((Book) any())).thenReturn(book);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        BookDto bookDto = mock(BookDto.class);
        when(bookDto.getAuthor()).thenReturn("JaneDoe");
        when(bookDto.getDescription()).thenReturn("The characteristics of someone or something");
        when(bookDto.getTitle()).thenReturn("Dr");
        when(bookDto.getIsbn()).thenReturn(1L);
        bookCommandServiceImp.addBook(bookDto);
        verify(iBookDAO).save((Book) any());
        verify(kafkaSender).send((String) any(), (BookDto) any());
        verify(bookDto).getAuthor();
        verify(bookDto).getDescription();
        verify(bookDto).getTitle();
        verify(bookDto).getIsbn();
    }

    /**
     * Method under test: {@link BookCommandServiceImp#updateBook(long, BookDto)}
     */
    @Test
    public void testUpdateBook() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);

        Book book1 = new Book();
        book1.setAuthor("JaneDoe");
        book1.setDescription("The characteristics of someone or something");
        book1.setIsbn(1L);
        book1.setTitle("Dr");
        when(iBookDAO.save((Book) any())).thenReturn(book1);
        when(iBookDAO.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        BookDto bookDto = new BookDto(1L, "Dr", "The characteristics of someone or something", "JaneDoe");

        assertSame(bookDto, bookCommandServiceImp.updateBook(1L, bookDto));
        verify(iBookDAO).save((Book) any());
        verify(iBookDAO).findById((Long) any());
        verify(kafkaSender).send((String) any(), (BookDto) any());
    }

    /**
     * Method under test: {@link BookCommandServiceImp#updateBook(long, BookDto)}
     */
    @Test
    public void testUpdateBook2() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        when(iBookDAO.save((Book) any())).thenReturn(book);
        when(iBookDAO.findById((Long) any())).thenReturn(Optional.empty());
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        BookDto bookDto = new BookDto(1L, "Dr", "The characteristics of someone or something", "JaneDoe");

        assertSame(bookDto, bookCommandServiceImp.updateBook(1L, bookDto));
        verify(iBookDAO).findById((Long) any());
    }

    /**
     * Method under test: {@link BookCommandServiceImp#updateBook(long, BookDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testUpdateBook3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at book.Service.adapter.BookAddapter.getBookFromBookDTO(BookAddapter.java:11)
        //       at book.Service.BookCommandServiceImp.updateBook(BookCommandServiceImp.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);

        Book book1 = new Book();
        book1.setAuthor("JaneDoe");
        book1.setDescription("The characteristics of someone or something");
        book1.setIsbn(1L);
        book1.setTitle("Dr");
        when(iBookDAO.save((Book) any())).thenReturn(book1);
        when(iBookDAO.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        bookCommandServiceImp.updateBook(1L, null);
    }

    /**
     * Method under test: {@link BookCommandServiceImp#updateBook(long, BookDto)}
     */
    @Test
    public void testUpdateBook4() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);

        Book book1 = new Book();
        book1.setAuthor("JaneDoe");
        book1.setDescription("The characteristics of someone or something");
        book1.setIsbn(1L);
        book1.setTitle("Dr");
        when(iBookDAO.save((Book) any())).thenReturn(book1);
        when(iBookDAO.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        BookDto bookDto = mock(BookDto.class);
        when(bookDto.getAuthor()).thenReturn("JaneDoe");
        when(bookDto.getDescription()).thenReturn("The characteristics of someone or something");
        when(bookDto.getTitle()).thenReturn("Dr");
        when(bookDto.getIsbn()).thenReturn(1L);
        bookCommandServiceImp.updateBook(1L, bookDto);
        verify(iBookDAO).save((Book) any());
        verify(iBookDAO).findById((Long) any());
        verify(kafkaSender).send((String) any(), (BookDto) any());
        verify(bookDto).getAuthor();
        verify(bookDto).getDescription();
        verify(bookDto).getTitle();
        verify(bookDto).getIsbn();
    }

    /**
     * Method under test: {@link BookCommandServiceImp#deleteBook(long)}
     */
    @Test
    public void testDeleteBook() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);
        doNothing().when(iBookDAO).deleteById((Long) any());
        when(iBookDAO.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        BookDto actualDeleteBookResult = bookCommandServiceImp.deleteBook(1L);
        assertEquals("JaneDoe", actualDeleteBookResult.getAuthor());
        assertEquals("Dr", actualDeleteBookResult.getTitle());
        assertEquals(1L, actualDeleteBookResult.getIsbn());
        assertEquals("The characteristics of someone or something", actualDeleteBookResult.getDescription());
        verify(iBookDAO).findById((Long) any());
        verify(iBookDAO).deleteById((Long) any());
        verify(kafkaSender).send((String) any(), (BookDto) any());
    }

    /**
     * Method under test: {@link BookCommandServiceImp#deleteBook(long)}
     */
    @Test
    public void testDeleteBook2() {
        Book book = mock(Book.class);
        when(book.getAuthor()).thenReturn("JaneDoe");
        when(book.getDescription()).thenReturn("The characteristics of someone or something");
        when(book.getTitle()).thenReturn("Dr");
        when(book.getIsbn()).thenReturn(1L);
        doNothing().when(book).setAuthor((String) any());
        doNothing().when(book).setDescription((String) any());
        doNothing().when(book).setIsbn(anyLong());
        doNothing().when(book).setTitle((String) any());
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        Optional<Book> ofResult = Optional.of(book);
        doNothing().when(iBookDAO).deleteById((Long) any());
        when(iBookDAO.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        BookDto actualDeleteBookResult = bookCommandServiceImp.deleteBook(1L);
        assertEquals("JaneDoe", actualDeleteBookResult.getAuthor());
        assertEquals("Dr", actualDeleteBookResult.getTitle());
        assertEquals(1L, actualDeleteBookResult.getIsbn());
        assertEquals("The characteristics of someone or something", actualDeleteBookResult.getDescription());
        verify(iBookDAO).findById((Long) any());
        verify(iBookDAO).deleteById((Long) any());
        verify(book).getAuthor();
        verify(book).getDescription();
        verify(book).getTitle();
        verify(book).getIsbn();
        verify(book).setAuthor((String) any());
        verify(book).setDescription((String) any());
        verify(book).setIsbn(anyLong());
        verify(book).setTitle((String) any());
        verify(kafkaSender).send((String) any(), (BookDto) any());
    }

    /**
     * Method under test: {@link BookCommandServiceImp#deleteBook(long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteBook3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at book.Service.BookCommandServiceImp.deleteBook(BookCommandServiceImp.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(iBookDAO).deleteById((Long) any());
        when(iBookDAO.findById((Long) any())).thenReturn(Optional.empty());
        Book book = mock(Book.class);
        when(book.getAuthor()).thenReturn("JaneDoe");
        when(book.getDescription()).thenReturn("The characteristics of someone or something");
        when(book.getTitle()).thenReturn("Dr");
        when(book.getIsbn()).thenReturn(1L);
        doNothing().when(book).setAuthor((String) any());
        doNothing().when(book).setDescription((String) any());
        doNothing().when(book).setIsbn(anyLong());
        doNothing().when(book).setTitle((String) any());
        book.setAuthor("JaneDoe");
        book.setDescription("The characteristics of someone or something");
        book.setIsbn(1L);
        book.setTitle("Dr");
        doNothing().when(kafkaSender).send((String) any(), (BookDto) any());
        bookCommandServiceImp.deleteBook(1L);
    }
}

