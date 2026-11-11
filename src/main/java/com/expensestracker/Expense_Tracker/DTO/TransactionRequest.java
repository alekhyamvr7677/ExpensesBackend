package com.expensestracker.Expense_Tracker.DTO;

import com.expensestracker.Expense_Tracker.Enum.CategoryType;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionRequest {

    private BigDecimal amount;
    private String description;
    private CategoryType transactionType;
    private LocalDateTime transactionDate;

    private Integer categoryId;
    private Long bankId;
}