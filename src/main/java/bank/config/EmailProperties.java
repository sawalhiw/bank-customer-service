package bank.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "email")
public class EmailProperties {
    private String username;
    private String password;
    private Integer port;
    private String host;
}
