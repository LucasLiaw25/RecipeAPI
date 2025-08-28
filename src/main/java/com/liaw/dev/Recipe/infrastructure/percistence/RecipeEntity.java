package com.liaw.dev.Recipe.infrastructure.percistence;

import com.liaw.dev.Recipe.core.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    String ingredient;

    @Enumerated(EnumType.STRING)
    Category category;

}
