package book.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import book.Service.dto.BookDto;
import book.Service.IBookCommandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BooksCommandController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BooksCommandControllerTest {
    @Autowired
    private BooksCommandController booksCommandController;

    @MockBean
    private IBookCommandService iBookCommandService;

    /**
     * Method under test: {@link BooksCommandController#addBook(BookDto)}
     */
    @Test
    public void testAddBook() throws Exception {
        when(iBookCommandService.addBook((BookDto) any()))
                .thenReturn(new BookDto(1L, "Dr", "The characteristics of someone or something", "JaneDoe"));

        BookDto bookDto = new BookDto();
        bookDto.setAuthor("JaneDoe");
        bookDto.setDescription("The characteristics of someone or something");
        bookDto.setIsbn(1L);
        bookDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(bookDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/books/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(booksCommandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"isbn\":1,\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\",\"author\":"
                                        + "\"JaneDoe\"}"));
    }

    /**
     * Method under test: {@link BooksCommandController#updateBook(long, BookDto)}
     */
    @Test
    public void testUpdateBook() throws Exception {
        when(iBookCommandService.updateBook(anyLong(), (BookDto) any()))
                .thenReturn(new BookDto(1L, "Dr", "The characteristics of someone or something", "JaneDoe"));

        BookDto bookDto = new BookDto();
        bookDto.setAuthor("JaneDoe");
        bookDto.setDescription("The characteristics of someone or something");
        bookDto.setIsbn(1L);
        bookDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(bookDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/books/update/{isbn}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(booksCommandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"isbn\":1,\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\",\"author\":"
                                        + "\"JaneDoe\"}"));
    }

    /**
     * Method under test: {@link BooksCommandController#deleteBook(long)}
     */
    @Test
    public void testDeleteBook() throws Exception {
        when(iBookCommandService.deleteBook(anyLong()))
                .thenReturn(new BookDto(1L, "Dr", "The characteristics of someone or something", "JaneDoe"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/books/delete/{isbn}", 1L);
        MockMvcBuilders.standaloneSetup(booksCommandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"isbn\":1,\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\",\"author\":"
                                        + "\"JaneDoe\"}"));
    }
}

