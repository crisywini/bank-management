package co.crisi.bank.entity;

import co.crisi.bank.data.AccountTypeDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {


    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private Float benefit;

    @ManyToOne
    @JoinTable(name = "client_accounts",
               joinColumns = @JoinColumn(name = "client_id",
                                         referencedColumnName = "client_id"),
               inverseJoinColumns = @JoinColumn(name = "account_id",
                                                referencedColumnName = "account_id")
    )
    private Client client;

    @Enumerated
    private AccountTypeDto type;

}
