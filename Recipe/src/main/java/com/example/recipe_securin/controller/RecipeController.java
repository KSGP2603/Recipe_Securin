package com.example.recipe_securin.controller;

import com.example.recipe_securin.entity.Recipe;
import com.example.recipe_securin.service.RecipeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @PostMapping
    public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) {

        if (recipe.getTitle() == null ||
                recipe.getCuisine() == null ||
                recipe.getPrepTime() == null ||
                recipe.getCookTime() == null) {

            return ResponseEntity.badRequest()
                    .body("title, cuisine, prep_time and cook_time are required.");
        }

        Recipe saved = recipeService.createRecipe(recipe);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("/top")
    public ResponseEntity<Map<String, List<Recipe>>> getTopRecipes(
            @RequestParam(defaultValue = "5") int limit) {

        List<Recipe> recipes =
                recipeService.getTopRecipes(limit);

        Map<String, List<Recipe>> response = new HashMap<>();
        response.put("data", recipes);

        return ResponseEntity.ok(response);
    }
}