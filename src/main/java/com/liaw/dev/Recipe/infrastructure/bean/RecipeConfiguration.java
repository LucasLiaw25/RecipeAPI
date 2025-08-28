package com.liaw.dev.Recipe.infrastructure.bean;

import com.liaw.dev.Recipe.core.gateway.RecipeGateway;
import com.liaw.dev.Recipe.core.usecase.CreateRecipeUseCase;
import com.liaw.dev.Recipe.core.usecase.CreateRecipeUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfiguration {

    @Bean
    public CreateRecipeUseCase createRecipeUseCase(RecipeGateway gateway){
        return new CreateRecipeUseCaseImpl(gateway);
    }

}
