package com.liaw.dev.Recipe.infrastructure.mapper;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.infrastructure.dto.RecipeDTO;

public class RecipeMapper {

    public RecipeDTO toDto(Recipe recipe){
        return new RecipeDTO(
                recipe.id(),
                recipe.title(),
                recipe.description(),
                recipe.description(),
                recipe.category()
        );
    }

    public Recipe toDomain(RecipeDTO dto){
        return new Recipe(
                dto.id(),
                dto.title(),
                dto.description(),
                dto.ingredient(),
                dto.category()
        );
    }

}
