package co.crisi.bank.config;

import co.crisi.bank.adapter.ClientJpaAdapter;
import co.crisi.bank.port.api.ClientServicePort;
import co.crisi.bank.port.spi.ClientPersistencePort;
import co.crisi.bank.service.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {


    @Bean
    public ClientPersistencePort clientPersistence() {
        return new ClientJpaAdapter();
    }

    @Bean
    public ClientServicePort clientService() {
        return new ClientServiceImpl(clientPersistence());
    }

}
