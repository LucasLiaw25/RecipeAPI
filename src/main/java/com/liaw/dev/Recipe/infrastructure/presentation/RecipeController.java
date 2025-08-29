package com.liaw.dev.Recipe.infrastructure.presentation;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.enums.Category;
import com.liaw.dev.Recipe.core.usecase.classes.*;
import com.liaw.dev.Recipe.infrastructure.dto.RecipeDTO;
import com.liaw.dev.Recipe.infrastructure.mapper.RecipeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/recipe/")
public class RecipeController {

    private final RecipeMapper mapper;
    private final ListRecipeUseCaseImpl listRecipe;
    private final CreateRecipeUseCaseImpl createRecipe;
    private final UpdateRecipeUseCaseImpl updateRecipe;
    private final DeleteRecipeUseCaseImpl deleteRecipe;
    private final SearchRecipeUseCaseImpl searchRecipe;
    private final SearchByCategoryUseCaseImpl searchByCategory;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> listRecipe(){
        List<Recipe> recipes = listRecipe.execute();
        List<RecipeDTO> dtos = recipes.stream()
                .map(mapper::toDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<RecipeDTO>> searchByCategory(@PathVariable Category category){
        List<Recipe> recipes = searchByCategory.execute(category);
        List<RecipeDTO> dtos = recipes.stream().map(mapper::toDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("search/")
    public ResponseEntity<List<RecipeDTO>> searchRecipe(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String ingredient
    ){
        List<Recipe> recipes = searchRecipe.execute(title, description, ingredient);
        List<RecipeDTO> dtos = recipes.stream()
                .map(mapper::toDto).toList();

        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody @Valid RecipeDTO dto){
        Recipe recipe = mapper.toDomain(dto);
        Recipe recipe_created = createRecipe.execute(recipe);
        return ResponseEntity.ok(mapper.toDto(recipe_created));
    }

    @PutMapping("{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id, @RequestBody @Valid RecipeDTO dto){
        Recipe recipe = updateRecipe.execute(id, mapper.toDomain(dto));
        RecipeDTO recipeDTO = mapper.toDto(recipe);
        return ResponseEntity.ok(recipeDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id){
        deleteRecipe.execute(id);
        return ResponseEntity.ok("Receita com id: "+id+" deletada com sucesso");
    }

}
