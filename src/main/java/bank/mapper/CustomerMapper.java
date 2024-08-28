package bank.mapper;

import bank.dto.CustomerDto;
import bank.entity.Customer;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
@AnnotateWith(GeneratedMapper.class)
public abstract class CustomerMapper extends BaseMapper<CustomerDto, Customer> {
}
