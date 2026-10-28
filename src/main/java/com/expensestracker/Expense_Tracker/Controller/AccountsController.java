package com.expensestracker.Expense_Tracker.Controller;


import com.expensestracker.Expense_Tracker.DTO.AccountRequest;
import com.expensestracker.Expense_Tracker.Entity.Accounts;
import com.expensestracker.Expense_Tracker.Service.AccountsService;
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

    @PostMapping("/createAccount")
    public Accounts createAccount(@RequestBody AccountRequest request){
        return accountsService.createAccount(request);
    }

}
