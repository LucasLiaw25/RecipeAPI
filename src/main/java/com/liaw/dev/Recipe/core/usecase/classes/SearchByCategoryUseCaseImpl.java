package com.liaw.dev.Recipe.core.usecase.classes;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.enums.Category;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.core.usecase.interfaces.SearchByCategoryUseCase;

import java.util.List;

public class SearchByCategoryUseCaseImpl implements SearchByCategoryUseCase {

    private final RecipeGateway recipeGateway;

    public SearchByCategoryUseCaseImpl(RecipeGateway recipeGateway) {
        this.recipeGateway = recipeGateway;
    }

    @Override
    public List<Recipe> execute(Category category) {
        return recipeGateway.searchByCategory(category);
    }
}
