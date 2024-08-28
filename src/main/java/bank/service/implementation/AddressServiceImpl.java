package bank.service.implementation;

import bank.dto.AddressDto;
import bank.dto.FeatureInfoDto;
import bank.entity.Address;
import bank.mapper.AddressMapper;
import bank.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressDto> {

    public AddressServiceImpl(AddressRepository repository,
                              AddressMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected FeatureInfoDto featureInfo() {
        return FeatureInfoDto
                .builder()
                .single("Address")
                .plural("Addresses")
                .build();
    }
}
