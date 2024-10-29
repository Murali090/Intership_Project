package com.InternShip.Backend.Model.Recepies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AiRecepie
 */

/**
 * AiRecepie
 */
public record AiRecepie(@JsonProperty(required = true, value = "Descrption") String Descrption,
    @JsonProperty(required = true, value = "Ingredients") String Ingredient,
    @JsonProperty(required = true, value = "instructions") String instructions) {
}
