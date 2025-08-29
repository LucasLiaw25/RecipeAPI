package com.liaw.dev.Recipe.infrastructure.dto;

import com.liaw.dev.Recipe.core.enums.Category;
import jakarta.validation.constraints.NotBlank;

public record RecipeDTO(
        Long id,
        @NotBlank String title,
        @NotBlank String description,
        @NotBlank String ingredient,
        Category category
) {
}
