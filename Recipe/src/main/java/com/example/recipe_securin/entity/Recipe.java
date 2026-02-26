package com.example.recipe_securin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String cuisine;

    private Float rating;

    @JsonProperty("prep_time")
    @Column(name = "prep_time")
    private Integer prepTime;

    @JsonProperty("cook_time")
    @Column(name = "cook_time")
    private Integer cookTime;

    @JsonProperty("total_time")
    @Column(name = "total_time")
    private Integer totalTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Embedded
    private Nutrients nutrients;

    private String serves;

    // Getters & Setters

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getCuisine() { return cuisine; }

    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public Float getRating() { return rating; }

    public void setRating(Float rating) { this.rating = rating; }

    public Integer getPrepTime() { return prepTime; }

    public void setPrepTime(Integer prepTime) { this.prepTime = prepTime; }

    public Integer getCookTime() { return cookTime; }

    public void setCookTime(Integer cookTime) { this.cookTime = cookTime; }

    public Integer getTotalTime() { return totalTime; }

    public void setTotalTime(Integer totalTime) { this.totalTime = totalTime; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Nutrients getNutrients() { return nutrients; }

    public void setNutrients(Nutrients nutrients) { this.nutrients = nutrients; }

    public String getServes() { return serves; }

    public void setServes(String serves) { this.serves = serves; }
}