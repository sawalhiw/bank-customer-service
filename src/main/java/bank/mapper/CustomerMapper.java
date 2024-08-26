package bank.mapper;

import bank.dto.CustomerDto;
import bank.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper extends BaseMapper<CustomerDto, Customer> {
}
