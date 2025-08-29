package com.liaw.dev.Recipe.core.usecase.classes;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.core.usecase.interfaces.CreateRecipeUseCase;

public class CreateRecipeUseCaseImpl implements CreateRecipeUseCase {

    private final RecipeGateway recipeGateway;

    public CreateRecipeUseCaseImpl(RecipeGateway recipeGateway) {
        this.recipeGateway = recipeGateway;
    }

    @Override
    public Recipe execute(Recipe recipe) {
        return recipeGateway.createRecipe(recipe);
    }
}
