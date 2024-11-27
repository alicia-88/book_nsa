package com.nsa.book_nsa.controller;

import com.nsa.book_nsa.model.Category;
import com.nsa.book_nsa.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Recherche toutes les catégories.
     * @return Liste des catégories.
     */
    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    /**
     * Récupérer une catégorie par son ID.
     * @param id Identifiant de la catégorie.
     * @return La catégorie correspondante.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    /**
     * Ajouter une nouvelle catégorie.
     * @param category Objet catégorie.
     * @return Catégorie créée.
     */
    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category) {
        Category createdCategory = categoryService.addCategory(category);
        return ResponseEntity.status(201).body(createdCategory);
    }

    /**
     * Mettre à jour une catégorie existante.
     * @param id Identifiant de la catégorie à mettre à jour.
     * @param category Objet catégorie avec les nouvelles informations.
     * @return Catégorie mise à jour.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @Valid @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    /**
     * Supprimer une catégorie par son ID.
     * @param id Identifiant de la catégorie à supprimer.
     * @return Une réponse sans contenu.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
