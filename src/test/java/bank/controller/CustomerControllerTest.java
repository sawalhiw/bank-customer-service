package bank.controller;

import bank.config.BaseWebTest;
import bank.dto.AddressDto;
import bank.dto.CustomerDto;
import bank.dto.Type;
import bank.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {
        CustomerController.class,
        CustomerService.class
})
@RunWith(SpringRunner.class)
public class CustomerControllerTest extends BaseWebTest<CustomerDto> {
    @MockBean
    private CustomerService service;
    private final String customerId = UUID.randomUUID().toString();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected String feature() {
        return "customers";
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        testDelete(customerId);
    }

    @Test
    public void testFindById() throws Exception {
        testGetById(customerId);
    }

    @Test
    public void testFindAll() throws Exception {
        testList(0, 10);
    }

    @Test
    public void testUpdateCustomerShouldReturnBadRequest() throws Exception {
        final CustomerDto dto = CustomerDto
                .builder()
                .id(customerId)
                .email("admin@gmail.com")
                .phoneNumber("+962796058883")
                .gender("male")
                .build();
        testPut(customerId, dto, status().isBadRequest());
    }

    @Test
    public void testUpdateCustomerShouldReturnOk() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.AUGUST, 3);

        final AddressDto customerAddress = AddressDto
                .builder()
                .state("Amman")
                .country("Jordan")
                .street("Mecca St")
                .build();
        final CustomerDto dto = CustomerDto
                .builder()
                .id(customerId)
                .name("admin")
                .associatedLegalId("1234567")
                .type(Type.INVESTMENT)
                .address(customerAddress)
                .dateOfBirth(new Date(calendar.getTimeInMillis()))
                .email("admin@gmail.com")
                .phoneNumber("+962796058883")
                .gender("male")
                .build();
        testPut(customerId, dto, status().isOk());
    }

    @Test
    public void testCreateCustomerShouldReturnOk() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.AUGUST, 3);

        final AddressDto customerAddress = AddressDto
                .builder()
                .state("Amman")
                .country("Jordan")
                .street("Mecca St")
                .build();
        final CustomerDto dto = CustomerDto
                .builder()
                .id(customerId)
                .name("admin")
                .associatedLegalId("1234567")
                .type(Type.INVESTMENT)
                .address(customerAddress)
                .dateOfBirth(new Date(calendar.getTimeInMillis()))
                .email("admin@gmail.com")
                .phoneNumber("+962796058883")
                .gender("male")
                .build();
        testPost(dto, status().isOk());
    }

    @Test
    public void testCreateCustomerShouldReturnBadRequest() throws Exception {
        final CustomerDto dto = CustomerDto
                .builder()
                .id(customerId)
                .email("admin@gmail.com")
                .phoneNumber("+962796058883")
                .gender("male")
                .build();
        testPost(dto, status().isBadRequest());
    }
}