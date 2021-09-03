package com.assignment.apidemo.service;

import com.assignment.apidemo.model.Reverse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class StringServiceTest {

    private static final String QUERY = "sevans";
    private static final String REVERSED_QUERY = "snaves";

    @InjectMocks
    private StringService stringService;

    @Test
    void reverse() {
        var expected = Reverse.builder()
                .result(REVERSED_QUERY)
                .build();

        assertEquals(expected, stringService.reverse(QUERY));
    }
}
