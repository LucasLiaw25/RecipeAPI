package com.liaw.dev.Recipe.core.usecase.interfaces;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.enums.Category;

import java.util.List;

public interface SearchByCategoryUseCase {
    List<Recipe> execute(Category category);
}
