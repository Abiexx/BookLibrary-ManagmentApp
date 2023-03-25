package borrowings.Controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import borrowings.service.BorrowingsService;
import borrowings.service.Dto.BorrowingDto;
import borrowings.service.Dto.BorrowingsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BorrowingsController.class})
@ExtendWith(SpringExtension.class)
class BorrowingsControllerTest {
    @Autowired
    private BorrowingsController borrowingsController;

    @MockBean
    private BorrowingsService borrowingsService;

    /**
     * Method under test: {@link BorrowingsController#addBorrowing(BorrowingDto)}
     */
    @Test
    void testAddBorrowing() throws Exception {
        when(borrowingsService.getBorrowings()).thenReturn(new BorrowingsDto());

        BorrowingDto borrowingDto = new BorrowingDto();
        borrowingDto.setBookTitle("Dr");
        borrowingDto.setBorrowingNumber(1L);
        borrowingDto.setCustomerName("Customer Name");
        borrowingDto.setCustomerNumber(1L);
        borrowingDto.setDate("2020-03-01");
        borrowingDto.setIsbn(1L);
        String content = (new ObjectMapper()).writeValueAsString(borrowingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/borrowings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(borrowingsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"borrowingsDTO\":null}"));
    }

    /**
     * Method under test: {@link BorrowingsController#getBorrowing(long)}
     */
    @Test
    void testGetBorrowing() throws Exception {
        when(borrowingsService.getBorrowing(anyLong()))
                .thenReturn(new BorrowingDto(1L, "2020-03-01", 1L, "Customer Name", 1L, "Dr"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/borrowings/{borrowingNumber}", 1L);
        MockMvcBuilders.standaloneSetup(borrowingsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"borrowingNumber\":1,\"date\":\"2020-03-01\",\"customerNumber\":1,\"customerName\":\"Customer Name\",\"isbn\":1,"
                                        + "\"bookTitle\":\"Dr\"}"));
    }

    /**
     * Method under test: {@link BorrowingsController#getBorrowings()}
     */
    @Test
    void testGetBorrowings() throws Exception {
        when(borrowingsService.getBorrowings()).thenReturn(new BorrowingsDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/borrowings");
        MockMvcBuilders.standaloneSetup(borrowingsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"borrowingsDTO\":null}"));
    }

    /**
     * Method under test: {@link BorrowingsController#getBorrowings()}
     */
    @Test
    void testGetBorrowings2() throws Exception {
        when(borrowingsService.getBorrowings()).thenReturn(new BorrowingsDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/borrowings");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(borrowingsController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"borrowingsDTO\":null}"));
    }

    /**
     * Method under test: {@link BorrowingsController#deleteBurrowing(long)}
     */
    @Test
    void testDeleteBurrowing() throws Exception {
        when(borrowingsService.deleteBorrowing(anyLong()))
                .thenReturn(new BorrowingDto(1L, "2020-03-01", 1L, "Customer Name", 1L, "Dr"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/borrowings/{borrowingNumber}", 1L);
        MockMvcBuilders.standaloneSetup(borrowingsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"borrowingNumber\":1,\"date\":\"2020-03-01\",\"customerNumber\":1,\"customerName\":\"Customer Name\",\"isbn\":1,"
                                        + "\"bookTitle\":\"Dr\"}"));
    }

    /**
     * Method under test: {@link BorrowingsController#updateBorrowing(long, BorrowingDto)}
     */
    @Test
    void testUpdateBorrowing() throws Exception {
        BorrowingDto borrowingDto = new BorrowingDto();
        borrowingDto.setBookTitle("Dr");
        borrowingDto.setBorrowingNumber(1L);
        borrowingDto.setCustomerName("Customer Name");
        borrowingDto.setCustomerNumber(1L);
        borrowingDto.setDate("2020-03-01");
        borrowingDto.setIsbn(1L);
        String content = (new ObjectMapper()).writeValueAsString(borrowingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/borrowings/borrowingNumber")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(borrowingsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }
}

