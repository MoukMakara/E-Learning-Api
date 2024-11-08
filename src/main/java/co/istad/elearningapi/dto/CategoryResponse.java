package co.istad.elearningapi.dto;

import lombok.Builder;

@Builder
public record CategoryResponse(
        Integer id,
        String name
) {
}
