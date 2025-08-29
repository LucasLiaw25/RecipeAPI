package com.liaw.dev.Recipe.core.usecase;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import org.w3c.dom.events.Event;

import java.util.List;

public class ListRecipeUseCaseImpl implements ListRecipeUseCase{

    private final RecipeGateway recipeGateway;

    public ListRecipeUseCaseImpl(RecipeGateway recipeGateway) {
        this.recipeGateway = recipeGateway;
    }

    @Override
    public List<Recipe> execute() {
        return recipeGateway.listRecipe();
    }
}
