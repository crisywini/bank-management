package co.crisi.bank.data;

public enum AccountTypeDto {

    CDAT(1),
    CDT(2);

    private final long id;

    AccountTypeDto(long id) {
        this.id = id;

    }
}
