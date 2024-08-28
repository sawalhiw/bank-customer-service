package bank.service.implementation;


import bank.dto.CustomerDto;
import bank.entity.Customer;
import bank.exception.NotFoundException;
import bank.mapper.CustomerMapper;
import bank.repository.CustomerRepository;
import bank.service.BaseServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"customerConfig"})
public class CustomerServiceImplTest extends BaseServiceTest<Customer, CustomerDto> {
    @MockBean
    private CustomerMapper mapper;
    @MockBean
    private CustomerRepository repository;

    @Before
    public void setup() {
        setup(mapper, repository, new CustomerServiceImpl(repository, mapper));
    }

    @Override
    protected Customer createEntity() {
        return Customer
                .builder()
                .id("1")
                .build();
    }

    @Override
    protected CustomerDto createDto() {
        return CustomerDto
                .builder()
                .id("1")
                .build();
    }

    @Test
    public void testFindAll() {
        super.testFindAll();
    }

    @Test
    public void testDeleteById() {
        super.testDeleteById();
    }

    @Test
    public void testFindById() {
        super.testFindById();
    }

    @Test
    public void testCreate() {
        super.testCreate();
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateByIdShouldThrowNotFoundException() {
        super.testUpdate();
    }

    public void testUpdateByIdShouldSuccess() {
        when(repository.existsById(any())).thenReturn(true);
        super.testUpdate();
    }

}