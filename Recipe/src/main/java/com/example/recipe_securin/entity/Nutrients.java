package com.example.recipe_securin.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

@Setter
@Getter
@Embeddable
public class Nutrients {
    private String calories;
    private String carbohydrateContent;
    private String proteinContent;
    private String fatContent;
}