package com.liaw.dev.Recipe.infrastructure.validator;

import com.liaw.dev.Recipe.infrastructure.exceptions.RecipeNotFoundException;
import com.liaw.dev.Recipe.infrastructure.exceptions.RecipeTitleDescriptionEqualsException;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeEntity;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RecipeValidation {

    private final RecipeRepository repository;

    public boolean existRecipeId(Long id){
        Optional<RecipeEntity> recipe = repository.findById(id);
        if (recipe.isEmpty()){
            throw new RecipeNotFoundException("Receita com id: "+id+" não encontrada");
        }
        return false;
    }

    public void existRecipeTitle(String title, String description){
        Optional<RecipeEntity> recipeEntity = repository.findByTitleAndDescription(title, description);
            if (recipeEntity.isPresent()){
                throw new RecipeTitleDescriptionEqualsException(
                        "Receita com título: "+title+" e descrição: "+description+" já existe");
            }
        }
}


