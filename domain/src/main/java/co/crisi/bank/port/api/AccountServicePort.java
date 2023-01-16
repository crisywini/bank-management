package co.crisi.bank.port.api;

import co.crisi.bank.data.AccountDto;
import java.util.List;
import java.util.Optional;

public interface AccountServicePort {

    AccountDto save(AccountDto account);

    List<AccountDto> findAll();

    Optional<AccountDto> findByClientId(Long clientId);

    void invest(Long accountId, Double amount);

    void withdraw(Long accountId, Double amount);

    void closeInvestment(Long accountId);

    void simulate(Long months);

}
