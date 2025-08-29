package com.liaw.dev.Recipe.infrastructure.percistence;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.enums.Category;
import com.liaw.dev.Recipe.infrastructure.percistence.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>, QueryByExampleExecutor<RecipeEntity> {
    Optional<RecipeEntity> findByTitleAndDescription(String title, String description);
    Optional<RecipeEntity> findByTitleAndDescriptionAndIngredient(
            String title, String description, String ingredient
    );
    List<RecipeEntity> findByCategory(Category category);

}
