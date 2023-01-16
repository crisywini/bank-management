package co.crisi.bank.port.api;

import co.crisi.bank.data.ClientDto;
import java.util.List;
import java.util.Optional;

public interface ClientServicePort {

    ClientDto save(ClientDto client);

    void delete(Long id);

    List<ClientDto> findAll();

    Optional<ClientDto> findById(Long id);


}
