package com.expensestracker.Expense_Tracker.Controller;


import com.expensestracker.Expense_Tracker.DTO.CategoryRequest;
import com.expensestracker.Expense_Tracker.Entity.Categories;
import com.expensestracker.Expense_Tracker.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("/categories")
    public List<Categories> getCategory(){
        return categoryService.getCategory();
    }

    @GetMapping("/categories/{id}")
    public Categories getCategorybyId(@PathVariable Integer id){
        return categoryService.getCategorybyId(id);
    }


    @PostMapping("/createCategory")
    public Categories createCategory(@RequestBody CategoryRequest categoryRequest){

       return categoryService.createCategory(categoryRequest);
    }
}
