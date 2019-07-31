package gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayApplicationStartUp {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplicationStartUp.class, args);

	
    }
	
	@Bean(name = "userRemoteAddressResolver")
    public KeyResolver userKeyResolver() {
		
        return exchange -> {
            return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        };
    }


}
