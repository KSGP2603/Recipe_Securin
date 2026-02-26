package com.example.recipe_securin.repository;

import com.example.recipe_securin.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByOrderByRatingDesc();
}
