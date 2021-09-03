package com.assignment.apidemo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.assignment.apidemo.exception.QueryException;
import com.assignment.apidemo.model.Reverse;
import com.assignment.apidemo.service.StringService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ApiDemoControllerTest {

    private static final String QUERY = "sevans";
    private static final String REVERSED_QUERY = "snaves";
    private static final String INVALID_QUERY = "s";

    @Mock
    private StringService stringService;

    @InjectMocks
    private ApiDemoController apiDemoController;

    @Test
    void reverse() {
        var reversed = Reverse.builder()
                .result(REVERSED_QUERY)
                .build();
        var expected = ResponseEntity.of(Optional.of(reversed));
        when(stringService.reverse(QUERY)).thenReturn(reversed);

        assertEquals(expected, apiDemoController.reverse(QUERY));
    }

    @Test
    void reversedInvalidQuery() {
        var exception = assertThrows(QueryException.class,
                () -> apiDemoController.reverse(INVALID_QUERY));

        assertEquals(ApiDemoController.INVALID_QUERY_MSG, exception.getSummary());
        assertEquals(ApiDemoController.INVALID_QUERY_DETAILS, exception.getDetails());
    }
}
