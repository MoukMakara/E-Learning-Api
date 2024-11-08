package co.istad.elearningapi.exception;

import lombok.Builder;

@Builder
public record FieldError(
        String field,
        String detail
) {
}
