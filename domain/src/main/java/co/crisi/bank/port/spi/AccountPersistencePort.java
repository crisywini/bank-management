package co.crisi.bank.port.spi;

import co.crisi.bank.data.AccountDto;
import java.util.List;
import java.util.Optional;

public interface AccountPersistencePort {

    AccountDto save(AccountDto account);

    Optional<AccountDto> findById(Long id);

    List<AccountDto> findAll();

    void delete(Long id);


}
