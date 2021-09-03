package com.assignment.apidemo.exception;

import com.assignment.apidemo.model.ErrorResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@AllArgsConstructor
public class ApiErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(final WebRequest webRequest, final boolean includeStackTrace) {
        final Map<String, Object> defaultErrorAttributes = super.getErrorAttributes(webRequest, false);
        final ErrorResponse errorResponse = ErrorResponse.fromDefaultAttributeMap(defaultErrorAttributes);
        return errorResponse.toAttributeMap();
    }

}
