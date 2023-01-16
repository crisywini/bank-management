package co.crisi.bank.port.spi;

import co.crisi.bank.data.ClientDto;
import java.util.List;
import java.util.Optional;

public interface ClientPersistencePort {

    ClientDto save(ClientDto client);

    void delete(Long id);

    Optional<ClientDto> findById(Long id);

    List<ClientDto> findAll();

}
