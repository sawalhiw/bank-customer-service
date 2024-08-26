package bank.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "bank-auth-service", url = "localhost:9090/api/auth")
public interface BankAuthServiceClient {

}
