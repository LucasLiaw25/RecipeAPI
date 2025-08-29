package com.liaw.dev.Recipe.core.usecase.interfaces;

import com.liaw.dev.Recipe.core.entities.Recipe;

public interface UpdateRecipeUseCase {
    Recipe execute(Long id, Recipe recipe);
}
