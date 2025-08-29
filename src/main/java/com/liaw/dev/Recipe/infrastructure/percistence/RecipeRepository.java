package com.liaw.dev.Recipe.infrastructure.percistence;

import com.liaw.dev.Recipe.infrastructure.percistence.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    Optional<RecipeEntity> findByTitleAndDescription(String title, String description);
}
