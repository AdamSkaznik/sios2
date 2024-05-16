package local.wpr.start.sios.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
//import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
public class LeafConfig {
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}