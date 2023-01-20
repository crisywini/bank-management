package co.crisi.bank.repository;

import co.crisi.bank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long>,
        JpaRepository<Client, Long> {


}
