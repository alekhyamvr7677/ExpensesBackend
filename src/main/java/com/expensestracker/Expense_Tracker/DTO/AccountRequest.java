package com.expensestracker.Expense_Tracker.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountRequest {

    private String bankName;
    private String accountType; // like salary or saving
    private BigDecimal openingBalance;
    private String currency;
    private Boolean isActive;
}
