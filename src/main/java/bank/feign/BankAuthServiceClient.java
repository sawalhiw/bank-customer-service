package bank.feign;

import lombok.Generated;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "bank-auth-service", url = "localhost:9090/api/auth")
@Generated
public interface BankAuthServiceClient {

}
