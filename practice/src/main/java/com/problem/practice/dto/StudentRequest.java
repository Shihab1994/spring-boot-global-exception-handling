package com.problem.practice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record StudentRequest(

        @NotBlank(message = "Name is required")
        String name,

        @Min(value = 1, message = "Age must be greater than 0")
        Integer age
) {
}
