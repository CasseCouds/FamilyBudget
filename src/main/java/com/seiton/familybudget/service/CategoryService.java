package com.seiton.familybudget.service;

import com.seiton.familybudget.exception.CategoryNotFoundException;
import com.seiton.familybudget.model.Category;
import com.seiton.familybudget.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

     public CategoryService(CategoryRepository categoryRepository){
         this.categoryRepository = categoryRepository;
     }

     public Category getCategory(long id) {
         Optional<Category> category = this.categoryRepository.findById(id);
         return category.orElseThrow(
                 () -> new CategoryNotFoundException()
         );
     }

     public long addCategory(Category category) {
         return this.categoryRepository.save(category).getId();
     }

     public void deleteCategory(long id){
         Category category = getCategory(id);
         this.categoryRepository.delete(category);
     }

     public void updateCategory(Category category) {
         this.categoryRepository.save(category);
     }
}
