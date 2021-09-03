package com.assignment.apidemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private Integer code;
    private String message;
    private String details;

    public static ErrorResponse fromDefaultAttributeMap(final Map<String, Object> defaultErrorAttributes) {
        return new ErrorResponse(
                ((Integer) defaultErrorAttributes.get("status")),
                (String) defaultErrorAttributes.getOrDefault("error", "no message available"),
                (String) defaultErrorAttributes.getOrDefault("message", "no details available"));
    }

    public Map<String, Object> toAttributeMap() {
        return Map.of(
                "code", code,
                "message", message,
                "details", details
        );
    }
}
