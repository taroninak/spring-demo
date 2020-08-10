package tk.taroninak.demo.config;

import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean
    public ConfigurableMapper mapper() {
        return new ConfigurableMapper();
    }
}
