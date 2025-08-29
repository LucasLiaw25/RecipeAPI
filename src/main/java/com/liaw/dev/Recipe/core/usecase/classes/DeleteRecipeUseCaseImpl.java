package com.liaw.dev.Recipe.core.usecase.classes;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.core.usecase.interfaces.DeleteRecipeUseCase;

public class DeleteRecipeUseCaseImpl implements DeleteRecipeUseCase {

    private final RecipeGateway recipeGateway;

    public DeleteRecipeUseCaseImpl(RecipeGateway recipeGateway) {
        this.recipeGateway = recipeGateway;
    }

    @Override
    public void execute(Long id) {
        recipeGateway.deleteRecipe(id);
    }
}
