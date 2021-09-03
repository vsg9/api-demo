package com.assignment.apidemo.exception;

import com.assignment.apidemo.controller.ApiDemoController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApiDemoExceptionHandlerTest {

    @InjectMocks
    private ApiDemoExceptionHandler apiDemoExceptionHandler;

    @Test
    void handleQueryException() {
        QueryException ex = mock(QueryException.class);

        when(ex.getSummary()).thenReturn(ApiDemoController.INVALID_QUERY_MSG);
        when(ex.getDetails()).thenReturn(ApiDemoController.INVALID_QUERY_DETAILS);

        var response = apiDemoExceptionHandler.handleQueryException(ex);
        var error = response.getBody();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assert error != null;
        assertEquals(HttpStatus.BAD_REQUEST.value(), error.getCode());
        assertEquals(ApiDemoController.INVALID_QUERY_MSG, error.getMessage());
        assertEquals(ApiDemoController.INVALID_QUERY_DETAILS, error.getDetails());
    }

    @Test
    void handleMissingServletRequestParameterException() {
        MissingServletRequestParameterException ex = mock(MissingServletRequestParameterException.class);
        var response = apiDemoExceptionHandler.handleMissingRequestParameter(ex);
        var error = response.getBody();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assert error != null;
        assertEquals(HttpStatus.BAD_REQUEST.value(), error.getCode());
        assertTrue(error.getMessage().contains("OpenAPI"));
    }
 }
