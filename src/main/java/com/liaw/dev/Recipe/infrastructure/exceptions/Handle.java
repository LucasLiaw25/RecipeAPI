package com.liaw.dev.Recipe.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handle {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecipeNotFoundException.class)
    public ErrorMessage handleRecipeNotFoundException(RecipeNotFoundException e){
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RecipeTitleDescriptionEqualsException.class)
    public ErrorMessage handleRecipeTitleDescriptionEqualsException(RecipeTitleDescriptionEqualsException e){
        return new ErrorMessage(HttpStatus.CONFLICT.value(), e.getMessage());
    }
}
