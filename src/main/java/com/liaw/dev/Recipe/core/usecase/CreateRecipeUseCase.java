package com.liaw.dev.Recipe.core.usecase;

import com.liaw.dev.Recipe.core.entities.Recipe;

public interface CreateRecipeUseCase {
    Recipe execute(Recipe recipe);
}
