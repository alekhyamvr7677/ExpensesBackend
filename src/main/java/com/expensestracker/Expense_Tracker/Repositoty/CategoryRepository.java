package com.expensestracker.Expense_Tracker.Repositoty;

import com.expensestracker.Expense_Tracker.Entity.Categories;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
