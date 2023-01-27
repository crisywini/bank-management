package co.crisi.bank.config;

import co.crisi.bank.adapter.AccountJpaAdapter;
import co.crisi.bank.port.api.AccountServicePort;
import co.crisi.bank.port.spi.AccountPersistencePort;
import co.crisi.bank.service.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {


    @Bean
    public AccountPersistencePort accountPersistence() {
        return new AccountJpaAdapter();
    }

    @Bean
    public AccountServicePort accountService() {
        return new AccountServiceImpl(accountPersistence());
    }

}
