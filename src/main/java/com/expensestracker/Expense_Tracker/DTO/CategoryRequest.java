package com.expensestracker.Expense_Tracker.DTO;

import com.expensestracker.Expense_Tracker.Enum.CategoryType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    private String categoryName;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
}
