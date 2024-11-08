package co.istad.elearningapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record CourseCreateRequest(
        @NotBlank(message = "Title is require")
        String title,
        String description,
        @NotNull
        @Positive(message = "Price must be positive")
        BigDecimal price
) {
}
