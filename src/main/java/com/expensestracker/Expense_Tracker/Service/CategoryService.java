package com.expensestracker.Expense_Tracker.Service;

import com.expensestracker.Expense_Tracker.DTO.CategoryRequest;
import com.expensestracker.Expense_Tracker.Entity.Categories;
import com.expensestracker.Expense_Tracker.Repositoty.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }


    public List<Categories> getCategory() {
        return categoryRepository.findAll();
    }

    public Categories createCategory(CategoryRequest categoryRequest) {
        Categories categories = new Categories();
        categories.setCategoryName(categoryRequest.getCategoryName());
        categories.setCategoryType(categoryRequest.getCategoryType());
        return categoryRepository.save(categories);
    }

    public Categories getCategorybyId(Integer id) {
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with "+id));
    }
}
