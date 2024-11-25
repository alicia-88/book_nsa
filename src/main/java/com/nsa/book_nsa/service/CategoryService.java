package com.nsa.book_nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nsa.book_nsa.exception.DuplicateException;
import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.Category;
import com.nsa.book_nsa.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Récupérer la liste de toutes les catégories.
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Récupérer une catégorie par son ID.
     */
    public Category getCategoryById(Long id) {

        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("category", id));
    }


    /**
     * Ajouter une nouvelle catégorie.
     */
    public Category addCategory(Category category2) {
        Category category = categoryRepository.findByName(category2.getName());
        if (category != null) {
        	
            throw new DuplicateException("Category", category.getId());
        }
        return categoryRepository.save(category2);
    }

    /**
     * Mettre à jour une catégorie existante.
     */
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = getCategoryById(id);
        
        Category category2 = categoryRepository.findByName(category.getName());
        if (category2 != null) {
        	
            throw new DuplicateException("Category", category2.getId());
        }
        
        existingCategory.setName(category.getName());
        

		return categoryRepository.save(existingCategory);


    }

    /**
     * Supprimer une catégorie par son ID.
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

