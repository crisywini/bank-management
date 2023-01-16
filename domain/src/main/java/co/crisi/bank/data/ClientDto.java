package co.crisi.bank.data;

import java.util.List;

public record ClientDto(Long id, String name, String lastName, List<AccountDto> accounts) {

}
