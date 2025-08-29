package com.liaw.dev.Recipe.core.usecase.classes;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.core.usecase.interfaces.SearchRecipeUseCase;

import java.util.List;

public class SearchRecipeUseCaseImpl implements SearchRecipeUseCase {

    private final RecipeGateway recipeGateway;

    public SearchRecipeUseCaseImpl(RecipeGateway recipeGateway) {
        this.recipeGateway = recipeGateway;
    }

    @Override
    public List<Recipe> execute(String title, String description, String ingredient) {
        return recipeGateway.searchRecipe(title, description, ingredient);
    }
}
