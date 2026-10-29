package com.expensestracker.Expense_Tracker.Controller;


import com.expensestracker.Expense_Tracker.DTO.AccountRequest;
import com.expensestracker.Expense_Tracker.Entity.Accounts;
import com.expensestracker.Expense_Tracker.Service.AccountsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountsController {

    private AccountsService accountsService;


    public AccountsController(AccountsService accountsService) {
        this.accountsService=accountsService;
    }

    @GetMapping("/accounts")
    public List<Accounts> getAllAccounts(){
        return accountsService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable Long id){
        Accounts account = accountsService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/accounts/delete/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
        boolean isDeleted = accountsService.deleteAccountById(id);
        if(isDeleted){
            return ResponseEntity.ok("user deleted successfully" +id);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found with Id"+id);
    }


    @PostMapping("/createAccount")
    public Accounts createAccount(@RequestBody AccountRequest request){
        return accountsService.createAccount(request);
    }

}
