package com.liaw.dev.Recipe.core.usecase.interfaces;

import com.liaw.dev.Recipe.core.entities.Recipe;

public interface DeleteRecipeUseCase {
    void execute(Long id);
}
