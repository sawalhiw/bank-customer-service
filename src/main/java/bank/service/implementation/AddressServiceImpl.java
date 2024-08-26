package bank.service.implementation;

import bank.dto.AddressDto;
import bank.entity.Address;
import bank.mapper.AddressMapper;
import bank.repository.AddressRepository;

public class AddressServiceImpl extends BaseServiceImpl<Address, AddressDto> {

    public AddressServiceImpl(AddressRepository repository,
                              AddressMapper mapper) {
        super(repository, mapper);
    }

}
