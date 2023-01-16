package co.crisi.bank.data;

public record AccountDto(Long id, Double amount, Float benefit, AccountTypeDto type, ClientDto client) {

}
