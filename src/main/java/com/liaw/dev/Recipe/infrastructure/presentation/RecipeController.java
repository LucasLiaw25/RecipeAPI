package com.liaw.dev.Recipe.infrastructure.presentation;

import com.liaw.dev.Recipe.core.entities.Recipe;
import com.liaw.dev.Recipe.core.usecase.classes.CreateRecipeUseCaseImpl;
import com.liaw.dev.Recipe.core.usecase.classes.DeleteRecipeUseCaseImpl;
import com.liaw.dev.Recipe.core.usecase.classes.ListRecipeUseCaseImpl;
import com.liaw.dev.Recipe.core.usecase.classes.UpdateRecipeUseCaseImpl;
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
    private final CreateRecipeUseCaseImpl createRecipe;
    private final UpdateRecipeUseCaseImpl updateRecipe;
    private final DeleteRecipeUseCaseImpl deleteRecipe;
    private final ListRecipeUseCaseImpl listRecipe;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> listRecipe(){
        List<Recipe> recipes = listRecipe.execute();
        List<RecipeDTO> dtos = recipes.stream()
                .map(mapper::toDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody @Valid RecipeDTO dto){
        Recipe recipe = mapper.toDomain(dto);
        createRecipe.execute(recipe);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id, @RequestBody @Valid RecipeDTO dto){
        Recipe recipe = updateRecipe.execute(id, mapper.toDomain(dto));
        RecipeDTO recipeDTO = mapper.toDto(recipe);
        return ResponseEntity.ok(recipeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id){
        deleteRecipe.execute(id);
        return ResponseEntity.ok("Receita com id: "+id+" deletada com sucesso");
    }

}
