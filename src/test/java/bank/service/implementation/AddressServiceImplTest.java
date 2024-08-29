package bank.service.implementation;

import bank.dto.AddressDto;
import bank.entity.Address;
import bank.exception.NotFoundException;
import bank.mapper.AddressMapper;
import bank.repository.AddressRepository;
import bank.service.BaseServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"addressConfig"})
public class AddressServiceImplTest extends BaseServiceTest<Address, AddressDto> {
    @MockBean
    private AddressMapper mapper;
    @MockBean
    private AddressRepository repository;

    @Before
    public void setup() {
        setup(mapper, repository, new AddressServiceImpl(repository, mapper));
    }

    @Override
    protected Address createEntity() {
        return Address
                .builder()
                .id("1")
                .build();
    }

    @Override
    protected AddressDto createDto() {
        return AddressDto
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

    @Test(expected = NotFoundException.class)
    public void testFindByIdShouldFail() {
        when(repository.findById("1")).thenReturn(Optional.empty());
        super.testFindByIdWithoutPreparingRepositoryCalls();
    }

    @Test
    public void testCreate() {
        super.testCreate();
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateByIdShouldThrowNotFoundException() {
        super.testUpdate();
    }

    @Test
    public void testUpdateByIdShouldSuccess() {
        when(repository.existsById(any())).thenReturn(true);
        super.testUpdate();
    }
}
