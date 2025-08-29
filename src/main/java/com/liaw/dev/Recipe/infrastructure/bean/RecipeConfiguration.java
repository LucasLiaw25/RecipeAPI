package com.liaw.dev.Recipe.infrastructure.bean;

import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.core.usecase.classes.CreateRecipeUseCaseImpl;
import com.liaw.dev.Recipe.core.usecase.classes.DeleteRecipeUseCaseImpl;
import com.liaw.dev.Recipe.core.usecase.classes.ListRecipeUseCaseImpl;
import com.liaw.dev.Recipe.core.usecase.classes.UpdateRecipeUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfiguration {

    @Bean
    public CreateRecipeUseCaseImpl createRecipeUseCase(RecipeGateway gateway){
        return new CreateRecipeUseCaseImpl(gateway);
    }

    @Bean
    public ListRecipeUseCaseImpl listRecipeUseCase(RecipeGateway gateway){
        return new ListRecipeUseCaseImpl(gateway);
    }

    @Bean
    public UpdateRecipeUseCaseImpl updateRecipeUseCase(RecipeGateway gateway){
        return new UpdateRecipeUseCaseImpl(gateway);
    }

    @Bean
    public DeleteRecipeUseCaseImpl deleteRecipeUseCase(RecipeGateway gateway){
        return new DeleteRecipeUseCaseImpl(gateway);
    }

}
