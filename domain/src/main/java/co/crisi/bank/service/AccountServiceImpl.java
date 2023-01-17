package co.crisi.bank.service;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.data.AccountTypeDto;
import co.crisi.bank.exception.BusinessException;
import co.crisi.bank.exception.ResourceNotFoundException;
import co.crisi.bank.port.api.AccountServicePort;
import co.crisi.bank.port.spi.AccountPersistencePort;
import java.util.List;
import java.util.function.BiPredicate;
import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class AccountServiceImpl implements AccountServicePort {

    private AccountPersistencePort accountPersistencePort;

    private final BiPredicate<Double, Double> IS_CORRECT_AMOUNT_TO_WITHDRAW
            = (amount, amountToWithdraw) -> amountToWithdraw <= amount;


    @Override
    public AccountDto save(AccountDto account) {
        return accountPersistencePort.save(account);
    }

    @Override
    public List<AccountDto> findAll() {
        return accountPersistencePort.findAll();
    }

    @Override
    public AccountDto findByClientId(Long clientId) {
        return accountPersistencePort.findByClientId(clientId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account with client id %d not found", clientId)));
    }

    @Override
    public AccountDto findById(Long id) {
        return accountPersistencePort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Account %d not found", id)));
    }

    @Override
    public AccountDto findByTypeAndId(Long id, AccountTypeDto accountTypeDto) {
        return accountPersistencePort.findByIdAndType(id, accountTypeDto)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("The account with id %d and account type %s was not found", id,
                                accountTypeDto)));
    }

    @Override
    public void update(Long id, AccountDto newAccountDto) {
        accountPersistencePort.update(id, newAccountDto);
    }

    @Override
    public void invest(Long accountId, Double amount) {
        val accountDto = findById(accountId);
        val newAccountData = new AccountDto(accountId, amount + accountDto.amount(),
                accountDto.benefit(), accountDto.type(), accountDto.client());
        update(accountId, newAccountData);
    }

    @Override
    public void withdraw(Long accountId, Double amount) {
        val accountDto = findByClientId(accountId);
        validateAmount(accountDto.amount(), amount);
        val newAccountData = new AccountDto(accountId, accountDto.amount() - amount,
                accountDto.benefit(), accountDto.type(), accountDto.client());
        update(accountId, newAccountData);
    }

    @Override
    public void closeInvestment(Long accountId, Long checkingAccountId) {
        val cdt = validateCloseInvestment(accountId);
        accountPersistencePort.delete(accountId);
        val checkingAccount = findById(checkingAccountId);
        val newAccountData = new AccountDto(checkingAccount.id(), checkingAccount.amount() + cdt.amount(),
                checkingAccount.benefit(),
                checkingAccount.type(), checkingAccount.client());
        update(checkingAccountId, newAccountData);
    }

    @Override
    public void simulate(Long months) {

    }

    private void validateAmount(Double amount, Double amountToWithdraw) {
        if (IS_CORRECT_AMOUNT_TO_WITHDRAW.negate().test(amount, amountToWithdraw)) {
            throw new BusinessException(
                    String.format("The amount to withdraw is incorrect, currently amount in the account is %d",
                            amount));

        }
    }


    private AccountDto validateCloseInvestment(Long accountId) {
        val cdt = findById(accountId);
        if (cdt.amount() == 0.0) {
            throw new BusinessException("The investment of the cdt is 0");
        }
        return cdt;
    }

}
