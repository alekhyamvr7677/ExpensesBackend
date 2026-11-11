package com.expensestracker.Expense_Tracker.Service;

import com.expensestracker.Expense_Tracker.DTO.TransactionRequest;
import com.expensestracker.Expense_Tracker.Entity.Accounts;
import com.expensestracker.Expense_Tracker.Entity.Categories;
import com.expensestracker.Expense_Tracker.Entity.Transactions;
import com.expensestracker.Expense_Tracker.Repositoty.AccountsRepository;
import com.expensestracker.Expense_Tracker.Repositoty.CategoryRepository;
import com.expensestracker.Expense_Tracker.Repositoty.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountsRepository accountsRepository;
    private final CategoryRepository categoriesRepository;

    public TransactionService(
            TransactionRepository transactionRepository,
            AccountsRepository accountsRepository,
            CategoryRepository categoriesRepository) {

        this.transactionRepository = transactionRepository;
        this.accountsRepository = accountsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    public List<Transactions> getTransactions() {
        return transactionRepository.findAll();
    }

    public Transactions createTransaction(TransactionRequest request) {

        // Find account using Long bankId
        Accounts account = accountsRepository.findById(request.getBankId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // Find category using Integer categoryId
        Categories category = categoriesRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));


        Transactions transaction = new Transactions();

        transaction.setAmount(request.getAmount());
        transaction.setDescription(request.getDescription());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setTransactionDate(request.getTransactionDate());

        transaction.setAccount(account);
        transaction.setCategory(category);

        return transactionRepository.save(transaction);

    }

    public Transactions updateTransaction(Long id, TransactionRequest transactionRequest) {

        Accounts account = accountsRepository.findById(transactionRequest.getBankId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // Find category using Integer categoryId
        Categories category = categoriesRepository.findById(transactionRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));


        com.expensestracker.Expense_Tracker.Entity.Transactions transactions = transactionRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
        transactions.setAmount(transactionRequest.getAmount());
        transactions.setDescription(transactionRequest.getDescription());
        transactions.setTransactionDate(transactionRequest.getTransactionDate());
        transactions.setTransactionType(transactionRequest.getTransactionType());

        transactions.setAccount(account);
        transactions.setCategory(category);


        return transactionRepository.save(transactions);

    }
}



