package bank.config;

import bank.controller.CustomerController;
import bank.mapper.CustomerMapper;
import bank.repository.CustomerRepository;
import bank.service.CustomerService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("customerConfig")
public class CustomerConfiguration {

    @Bean
    public CustomerController customerController() {
        return Mockito.mock(CustomerController.class);
    }

    @Bean
    public CustomerService customerService() {
        return Mockito.mock(CustomerService.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public CustomerMapper customerMapper() {
        return Mockito.mock(CustomerMapper.class);
    }
}
