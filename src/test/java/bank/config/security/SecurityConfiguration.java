package bank.config.security;

import bank.feign.BankAuthServiceClient;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Configuration
@EnableWebSecurity
@Profile("test")
public class SecurityConfiguration {
    @Bean
    public BankAuthServiceClient bankAuthServiceClient() {
        final BankAuthServiceClient client = Mockito.mock(BankAuthServiceClient.class);
        ResponseEntity entity = ResponseEntity.ok().build();
        when(client.validateToken(any())).thenReturn(entity);
        return client;
    }
}
