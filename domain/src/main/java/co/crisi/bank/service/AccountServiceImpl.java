package co.crisi.bank.service;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.port.api.AccountServicePort;
import co.crisi.bank.port.spi.AccountPersistencePort;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountServiceImpl implements AccountServicePort {

    private AccountPersistencePort accountPersistencePort;

    @Override
    public AccountDto save(AccountDto account) {
        return null;
    }

    @Override
    public List<AccountDto> findAll() {
        return null;
    }

    @Override
    public AccountDto findByClientId(Long clientId) {
        return null;
    }

    @Override
    public void invest(Long accountId, Double amount) {

    }

    @Override
    public void withdraw(Long accountId, Double amount) {

    }

    @Override
    public void closeInvestment(Long accountId) {

    }

    @Override
    public void simulate(Long months) {

    }

}
