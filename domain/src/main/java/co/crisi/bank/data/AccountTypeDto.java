package co.crisi.bank.data;

public enum AccountTypeDto {

    CHECKING(3),
    CDAT(1),
    CDT(2);

    private final long id;

    AccountTypeDto(long id) {
        this.id = id;

    }

    public Long getId() {
        return this.id;
    }
}
