package com.liaw.dev.Recipe.core.usecase;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;

import java.util.Optional;

public class UpdateRecipeUseCaseImpl implements UpdateRecipeUseCase{

    private final RecipeGateway recipeGateway;

    public UpdateRecipeUseCaseImpl(RecipeGateway recipeGateway) {
        this.recipeGateway = recipeGateway;
    }

    @Override
    public Recipe execute(Long id, Recipe recipe) {
        return recipeGateway.updateRecipe(id, recipe);
    }
}
