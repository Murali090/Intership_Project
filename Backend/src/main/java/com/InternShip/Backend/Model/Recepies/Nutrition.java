package com.InternShip.Backend.Model.Recepies;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Nutrition(@JsonProperty(required = true, value = "Descrption") String Descrption,
    @JsonProperty(required = true, value = "fat") String fat,
    @JsonProperty(required = true, value = "Calories") String Calories,
    @JsonProperty(required = true, value = "frequency") String frequency,
    @JsonProperty(required = true, value = "Potential_health_hazards") String Potential_health_hazards) {
}
