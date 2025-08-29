package com.liaw.dev.Recipe.core.gateway;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.enums.Category;

import java.util.List;
import java.util.Optional;

public interface RecipeGateway {
    Recipe createRecipe(Recipe recipe);
    List<Recipe> listRecipe();
    Recipe updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
    List<Recipe> searchRecipe(String title, String description, String ingredient);
    List<Recipe> searchByCategory(Category category);
}
