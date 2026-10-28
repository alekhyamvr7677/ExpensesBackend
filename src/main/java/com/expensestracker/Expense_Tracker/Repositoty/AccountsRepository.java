package com.expensestracker.Expense_Tracker.Repositoty;

import com.expensestracker.Expense_Tracker.Entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
