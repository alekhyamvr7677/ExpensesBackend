package com.expensestracker.Expense_Tracker.Repositoty;

import com.expensestracker.Expense_Tracker.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {

}
