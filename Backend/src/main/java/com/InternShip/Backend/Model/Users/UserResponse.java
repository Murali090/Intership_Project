package com.InternShip.Backend.Model.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserResponse
 */
/**
 * UserResponse
 */
public record UserResponse(@JsonProperty(required = true, value = "Question") String Question,
    @JsonProperty(required = true, value = "Answer") String Answer) {
}
