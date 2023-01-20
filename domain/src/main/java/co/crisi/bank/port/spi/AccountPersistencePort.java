package co.crisi.bank.port.spi;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.data.AccountTypeDto;
import java.util.List;
import java.util.Optional;

/**
 * The SPI (Service Provider Interface) has all the service required by the domain to retrieve information from third
 * parties.
 */
public interface AccountPersistencePort {

    AccountDto save(AccountDto account);

    Optional<AccountDto> findById(Long id);

    List<AccountDto> findByClientId(Long clientId);

    List<AccountDto> findAll();

    void delete(Long id);

    void update(Long id, AccountDto newAccountData);

    Optional<AccountDto> findByIdAndType(Long id, AccountTypeDto type);

}
