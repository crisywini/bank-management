package co.crisi.bank.mapper;

import co.crisi.bank.data.ClientDto;
import co.crisi.bank.entity.Account;
import co.crisi.bank.entity.Client;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = AccountMapper.class)
public interface ClientMapper {


    Client mapToEntity(ClientDto clientDto);

    ClientDto mapToDto(Client client);

    List<Client> mapToEntities(List<ClientDto> clientDtos);

    List<ClientDto> mapToDtos(List<Client> clients);

    @AfterMapping
    default void setClientToAcountsReference(
            @MappingTarget
                    Client client) {
        client.getAccounts()
                .forEach(account -> account.setClient(client));
    }

}
