package co.crisi.bank.port.spi;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.data.AccountTypeDto;
import java.util.List;
import java.util.Optional;

public interface AccountPersistencePort {

    AccountDto save(AccountDto account);

    Optional<AccountDto> findById(Long id);

    List<AccountDto> findByClientId(Long clientId);

    List<AccountDto> findAll();

    void delete(Long id);

    void update(Long id, AccountDto newAccountData);

    Optional<AccountDto> findByIdAndType(Long id, AccountTypeDto type);

}
