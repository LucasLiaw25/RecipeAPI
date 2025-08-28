package com.liaw.dev.Recipe.infrastructure.gateway;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.infrastructure.mapper.RecipeEntityMapper;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeEntity;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecipeRepositoryGateway implements RecipeGateway {

    private final RecipeRepository repository;
    private final RecipeEntityMapper mapper;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        RecipeEntity entity = mapper.toEntity(recipe);
        repository.save(entity);
        return recipe;
    }
}
