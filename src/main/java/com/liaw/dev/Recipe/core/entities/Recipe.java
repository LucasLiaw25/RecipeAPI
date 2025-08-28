package com.liaw.dev.Recipe.core.entities;

import com.liaw.dev.Recipe.core.enums.Category;

public record Recipe(
        Long id,
        String title,
        String description,
        String ingredient,
        Category category
) {
}
