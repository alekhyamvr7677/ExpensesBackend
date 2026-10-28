package com.expensestracker.Expense_Tracker.Service;

import com.expensestracker.Expense_Tracker.DTO.AccountRequest;
import com.expensestracker.Expense_Tracker.Entity.Accounts;
import com.expensestracker.Expense_Tracker.Repositoty.AccountsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class AccountsService {
    private final AccountsRepository accountsRepository;

    // construcor injection
    public AccountsService(AccountsRepository accountsRepository){
        this.accountsRepository=accountsRepository;
    }

    public List<Accounts> getAllAccounts(){
        return accountsRepository.findAll();
    }

    public Accounts createAccount(AccountRequest request) {
        Accounts account = new Accounts();
        account.setAccountType(request.getAccountType());
        account.setBankName(request.getBankName());
        account.setOpeningBalance(
                Objects.requireNonNullElse(
                        request.getOpeningBalance(),
                        BigDecimal.ZERO
                )
        );
        account.setCurrency(
                Objects.requireNonNullElse(request.getCurrency(), "INR")
        );
        account.setIsActive(
                Objects.requireNonNullElse(request.getIsActive(), true)
        );

        return accountsRepository.save(account);
    }

}
