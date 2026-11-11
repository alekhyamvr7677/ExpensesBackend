package com.expensestracker.Expense_Tracker.Entity;

import com.expensestracker.Expense_Tracker.Enum.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private BigDecimal amount;
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryType transactionType;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name="bank_id")
    private Accounts account;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }


    public void setTransactionDate(LocalDateTime transactionDate) {
    }
}
