package co.crisi.bank.mapper;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.entity.Account;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    Account mapToEntity(AccountDto accountDto);

    AccountDto mapToDto(Account account);

    List<Account> mapToEntities(List<AccountDto> accountDtos);

    List<AccountDto> mapToDtos(List<Account> accounts);

}
