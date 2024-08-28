package bank.config;

import bank.mapper.AddressMapper;
import bank.repository.AddressRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("addressConfig")
public class AddressConfiguration {

    @Bean
    public AddressRepository addressRepository() {
        return Mockito.mock(AddressRepository.class);
    }

    @Bean
    public AddressMapper addressMapper() {
        return Mockito.mock(AddressMapper.class);
    }
}
