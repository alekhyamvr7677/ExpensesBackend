package com.expensestracker.Expense_Tracker.Controller;

import com.expensestracker.Expense_Tracker.DTO.TransactionRequest;
import com.expensestracker.Expense_Tracker.Entity.Transactions;
import com.expensestracker.Expense_Tracker.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {
    private TransactionService transactionService;
    public TransactionController(TransactionService transactionService){
        this.transactionService= transactionService;
    }

    @GetMapping("/transactions")
    public List<Transactions> getTransactions(){
        return transactionService.getTransactions();
    }

    @PostMapping("/transactions/create")
    public Transactions createTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.createTransaction(transactionRequest);
    }

//    id wise

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transactions> updateTransaction(@PathVariable Long id, @RequestBody TransactionRequest transactionRequest){
        Transactions transactions = transactionService.updateTransaction(id,transactionRequest);
        return ResponseEntity.ok(transactions);
    }

}
