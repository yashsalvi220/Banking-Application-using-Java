package net.javaguides.banking.controller;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.service.Accountservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api/accounts")
public class Accountcontroller {
    private Accountservice accountservice;

    public Accountcontroller(Accountservice accountservice) {
        this.accountservice = accountservice;
    }

    // Add Account REST API
    @PostMapping
    public ResponseEntity<Accountdto> addAccount (@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountservice.createAccount(accountdto), HttpStatus.CREATED);
    }
    // Get Account REST API
    @GetMapping ("/{Id}")
    public ResponseEntity<Accountdto> getAccountById(@PathVariable Long Id) {
        Accountdto accountdto = accountservice.getAccountById(Id);
        return ResponseEntity.ok(accountdto);
    }
    // Deposit REST API
    @PutMapping("/{Id}/deposit")
    public ResponseEntity<Accountdto> deposit(@PathVariable Long Id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        Accountdto accountdto = accountservice.deposit(Id,amount);
        return ResponseEntity.ok(accountdto);
    }
    // Withdraw REST API
    @PutMapping("/{Id}/withdraw")
    public ResponseEntity<Accountdto> withdraw(@PathVariable Long Id,
                                               @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        Accountdto accountdto = accountservice.withdraw(Id, amount);
        return ResponseEntity.ok(accountdto);
    }
    // Get All Accounts REST API
    @GetMapping
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto> accounts = accountservice.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    // Delete Account REST API
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long Id){
        accountservice.deleteAccount(Id);
        return ResponseEntity.ok("Account is successfully deleted");
    }
}
