package bank.config.security;

import bank.feign.BankAuthServiceClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final BankAuthServiceClient authServiceClient;

    public TokenAuthenticationFilter(BankAuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && !token.isEmpty()) {
            ResponseEntity<?> responseEntity = authServiceClient.validateToken(token);
//            if (!responseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
//                throw new CredentialsExpiredException("Authentication Failed.");
//            }
        }

        chain.doFilter(request, response);
    }
}