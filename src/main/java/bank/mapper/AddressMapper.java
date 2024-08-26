package bank.mapper;

import bank.dto.AddressDto;
import bank.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AddressMapper extends BaseMapper<AddressDto, Address>{
}
