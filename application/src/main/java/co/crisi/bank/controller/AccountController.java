package co.crisi.bank.controller;

import co.crisi.bank.data.AccountDto;
import co.crisi.bank.data.AccountTypeDto;
import co.crisi.bank.port.api.AccountServicePort;
import java.util.Objects;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServicePort accountServicePort;

    @PostMapping
    public ResponseEntity<Long> save(
            @RequestBody
                    AccountDto accountDto) {
        val savedAccount = accountServicePort.save(accountDto);
        return ResponseEntity.ok(savedAccount.id());
    }

    @GetMapping
    public ResponseEntity<AccountDto> findById(
            @RequestParam(name = "accountId")
                    Long accountId,
            @RequestParam(name = "type", required = false)
                    AccountTypeDto type) {

        val account = (Objects.nonNull(type)) ? accountServicePort.findByTypeAndId(accountId, type)
                : accountServicePort.findById(accountId);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Void> update(
            @PathVariable(name = "accountId")
                    Long accountId,
            @RequestBody
                    AccountDto newAccountInfo) {
        accountServicePort.update(accountId, newAccountInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/investment")
    public ResponseEntity<Void> invest(
            @RequestParam(name = "accountId")
                    Long accountId,
            @RequestParam(name = "amount")
                    Double amount) {

        accountServicePort.invest(accountId, amount);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Void> withdraw(
            @RequestParam(name = "accountId")
                    Long accountId,
            @RequestParam(name = "amount")
                    Double amount) {
        accountServicePort.withdraw(accountId, amount);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/investment/close")
    public ResponseEntity<Void> closeInvestment(
            @RequestParam(name = "accountId")
                    Long accountId,
            @RequestParam(name = "checkingAccountId")
                    Long checkingAccountId) {
        accountServicePort.closeInvestment(accountId, checkingAccountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/simulate/{clientId}")
    public ResponseEntity<AccountDto> simulate(
            @PathVariable(name = "clientId")
                    Long clientId,
            @RequestParam(name = "months")
                    Long months) {
        val accountSimulated = accountServicePort.simulate(clientId, months);
        return ResponseEntity.ok(accountSimulated);
    }

}
