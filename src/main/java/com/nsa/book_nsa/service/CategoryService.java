package com.nsa.book_nsa.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

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
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Ajouter une nouvelle catégorie.
     */
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Mettre à jour une catégorie existante.
     */
    public Category updateCategory(Long id, Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(id);

        if (existingCategory.isPresent()) {
            Category updatedCategory = existingCategory.get();
            updatedCategory.setName(category.getName());
            return categoryRepository.save(updatedCategory);
        } else {
            throw new RuntimeException("Catégorie introuvable avec l'ID : " + id);
        }
    }

    /**
     * Supprimer une catégorie par son ID.
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

