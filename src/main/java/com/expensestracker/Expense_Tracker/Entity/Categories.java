package com.expensestracker.Expense_Tracker.Entity;

import com.expensestracker.Expense_Tracker.Enum.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String categoryName;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

}
