package com.seiton.familybudget.controller;

import com.seiton.familybudget.model.Category;
import com.seiton.familybudget.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/telegramm")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @PostMapping("/category/new")
    public long addCategory(@Valid @RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") long id){
        return categoryService.getCategory(id);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/category/{id}")
    public void updateCategory(@Valid @RequestBody Category category) {
        categoryService.updateCategory(category);
    }
}
