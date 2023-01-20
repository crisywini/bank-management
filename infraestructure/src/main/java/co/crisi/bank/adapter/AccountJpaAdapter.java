package co.crisi.bank.adapter;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.data.AccountTypeDto;
import co.crisi.bank.entity.Account;
import co.crisi.bank.exception.ResourceNotFoundException;
import co.crisi.bank.mapper.AccountMapper;
import co.crisi.bank.port.spi.AccountPersistencePort;
import co.crisi.bank.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import lombok.val;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountJpaAdapter implements AccountPersistencePort {

    @Autowired
    private AccountRepository accountRepository;

    private final AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    @Override
    public AccountDto save(AccountDto account) {
        val accountEntity = accountMapper.mapToEntity(account);
        return accountMapper.mapToDto(accountRepository.save(accountEntity));
    }

    @Override
    public Optional<AccountDto> findById(Long id) {
        val account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Could not found an account with id %d ", id)));
        return Optional.of(accountMapper.mapToDto(account));
    }

    @Override
    public List<AccountDto> findByClientId(Long clientId) {
        val allByClientId = accountRepository.findAllByClientId(clientId);
        return accountMapper.mapToDtos(allByClientId);
    }

    @Override
    public List<AccountDto> findAll() {
        return accountMapper.mapToDtos(accountRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void update(Long id, AccountDto newAccountData) {
        Optional<AccountDto> findById = findById(id);
        findById.ifPresent(accountDto -> {
            val account = accountMapper.mapToEntity(accountDto);
            account.setId(accountDto.id());
            accountRepository.save(account);
        });
    }

    @Override
    public Optional<AccountDto> findByIdAndType(Long id, AccountTypeDto type) {
        val account = accountRepository.findOneByIdAndType(id, type)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Could not found the account by if %d and type %d", id, type.getId())));
        return Optional.of(accountMapper.mapToDto(account));
    }

}
