package bank.service.implementation;

import bank.dto.CustomerDto;
import bank.dto.FeatureInfoDto;
import bank.entity.Customer;
import bank.mapper.CustomerMapper;
import bank.repository.CustomerRepository;
import bank.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerDto> implements CustomerService {

    public CustomerServiceImpl(final CustomerRepository repository,
                               final CustomerMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected FeatureInfoDto featureInfo() {
        return FeatureInfoDto
                .builder()
                .single("Customer")
                .plural("Customers")
                .build();
    }
}
