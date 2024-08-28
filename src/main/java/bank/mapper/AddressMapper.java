package bank.mapper;

import bank.dto.AddressDto;
import bank.entity.Address;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@AnnotateWith(GeneratedMapper.class)
public abstract class AddressMapper extends BaseMapper<AddressDto, Address>{
}
