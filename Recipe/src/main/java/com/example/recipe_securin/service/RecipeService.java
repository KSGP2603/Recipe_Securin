package com.example.recipe_securin.service;

import com.example.recipe_securin.entity.Recipe;
import com.example.recipe_securin.repository.RecipeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.*;
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @PostConstruct
    public void loadJsonData() {
        try {
            if (recipeRepository.count() > 0) return;

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream =
                    getClass().getResourceAsStream("/recipes.json");

            Map<String, Recipe> recipeMap =
                    mapper.readValue(inputStream, new TypeReference<>() {});

            List<Recipe> recipes = new ArrayList<>(recipeMap.values());

            for (Recipe recipe : recipes) {
                if (recipe.getPrepTime() != null &&
                        recipe.getCookTime() != null) {

                    recipe.setTotalTime(
                            recipe.getPrepTime() + recipe.getCookTime()
                    );
                }
            }

            recipeRepository.saveAll(recipes);
            System.out.println("All recipes successfully inserted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Recipe createRecipe(Recipe recipe) {

        if (recipe.getPrepTime() != null &&
                recipe.getCookTime() != null) {

            recipe.setTotalTime(
                    recipe.getPrepTime() + recipe.getCookTime()
            );
        }

        return recipeRepository.save(recipe);
    }
    public List<Recipe> getTopRecipes(int limit) {

        List<Recipe> sorted =
                recipeRepository.findByOrderByRatingDesc();

        return sorted.stream().limit(limit).toList();
    }
}