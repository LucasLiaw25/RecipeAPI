package com.liaw.dev.Recipe.infrastructure.gateway;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.enums.Category;
import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.infrastructure.mapper.RecipeEntityMapper;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeEntity;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeRepository;
import com.liaw.dev.Recipe.infrastructure.validator.RecipeValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RecipeRepositoryGateway implements RecipeGateway {

    private final RecipeValidation validation;
    private final RecipeRepository repository;
    private final RecipeEntityMapper mapper;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        validation.existRecipeTitle(recipe.title(), recipe.description());
        RecipeEntity entity = mapper.toEntity(recipe);
        repository.save(entity);
        return recipe;
    }

    @Override
    public List<Recipe> listRecipe() {
        List<RecipeEntity> recipeEntity = repository.findAll();
        List<Recipe> recipes = recipeEntity.stream()
                .map(mapper::toDomain).toList();
        return recipes;
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        validation.existRecipeId(id);
        RecipeEntity recipeEntity = mapper.toEntity(recipe);
        recipeEntity.setId(id);
        repository.save(recipeEntity);
        return recipe;
    }

    @Override
    public void deleteRecipe(Long id) {
        validation.existRecipeId(id);
        repository.deleteById(id);
    }

    @Override
    public List<Recipe> searchRecipe(String title, String description, String ingredient) {
        validation.validateSearchRecipe(title, description, ingredient);

        RecipeEntity entity = new RecipeEntity();
        entity.setTitle(title);
        entity.setDescription(description);
        entity.setIngredient(ingredient);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<RecipeEntity> example = Example.of(entity, matcher);
        List<RecipeEntity> recipeEntities = repository.findAll(example);
        List<Recipe> recipes = recipeEntities.stream()
                .map(mapper::toDomain).toList();

        return recipes;
    }

    @Override
    public List<Recipe> searchByCategory(Category category) {
        validation.existCategory(category);
        List<RecipeEntity> entities = repository.findByCategory(category);
        List<Recipe> recipes = entities.stream()
                .map(mapper::toDomain).toList();
        return recipes;
    }


}
