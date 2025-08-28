package com.liaw.dev.Recipe.core.gateway;

import com.liaw.dev.Recipe.core.entities.Recipe;

public interface RecipeGateway {
    Recipe createRecipe(Recipe recipe);
}
