package co.crisi.bank.port.api;

import co.crisi.bank.data.ClientDto;
import java.util.List;

public interface ClientServicePort {

    ClientDto save(ClientDto client);

    void delete(Long id);

    List<ClientDto> findAll();

    ClientDto findById(Long id);


}
