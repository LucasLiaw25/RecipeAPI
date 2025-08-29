package com.liaw.dev.Recipe.core.usecase.interfaces;

import com.liaw.dev.Recipe.core.entities.Recipe;

import java.util.List;

public interface SearchRecipeUseCase {
    List<Recipe> execute(String title, String description, String ingredient);
}
