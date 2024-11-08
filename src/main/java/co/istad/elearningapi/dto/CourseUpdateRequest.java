package co.istad.elearningapi.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CourseUpdateRequest(
        String title,
        String description,
        BigDecimal price
) {
}
