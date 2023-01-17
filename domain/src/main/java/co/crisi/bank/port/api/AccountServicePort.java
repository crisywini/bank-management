package co.crisi.bank.port.api;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.data.AccountTypeDto;
import java.util.List;

public interface AccountServicePort {

    AccountDto save(AccountDto account);

    List<AccountDto> findAll();

    AccountDto findById(Long id);

    AccountDto findByTypeAndId(Long id, AccountTypeDto accountTypeDto);

    void update(Long id, AccountDto newAccountDto);

    void invest(Long accountId, Double amount);

    void withdraw(Long accountId, Double amount);

    void closeInvestment(Long accountId, Long checkingAccountId);

    AccountDto simulate(Long clientId, Long months);

}
