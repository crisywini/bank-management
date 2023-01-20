package co.crisi.bank.repository;

import co.crisi.bank.data.AccountTypeDto;
import co.crisi.bank.entity.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>,
        JpaRepository<Account, Long> {

    List<Account> findAllByClientId(Long clientId);

    Optional<Account> findOneByIdAndType(Long id, AccountTypeDto type);

}
