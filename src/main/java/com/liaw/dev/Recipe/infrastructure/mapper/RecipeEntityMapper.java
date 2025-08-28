package com.liaw.dev.Recipe.infrastructure.mapper;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeEntity;

public class RecipeEntityMapper {

    public RecipeEntity toEntity(Recipe recipe){
        return new RecipeEntity(
                recipe.id(),
                recipe.title(),
                recipe.description(),
                recipe.ingredient(),
                recipe.category()
        );
    }

    public Recipe toDomain(RecipeEntity entity){
        return new Recipe(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getIngredient(),
                entity.getCategory()
        );
    }

}
