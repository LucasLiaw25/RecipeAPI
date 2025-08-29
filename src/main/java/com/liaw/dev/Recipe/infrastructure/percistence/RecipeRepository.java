gpackage com.liaw.dev.Recipe.infrastructure.percistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    Optional<RecipeEntity> findByTitleAndDescription(String title, String description);
}
