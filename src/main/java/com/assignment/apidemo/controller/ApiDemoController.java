package com.assignment.apidemo.controller;

import com.assignment.apidemo.exception.QueryException;
import com.assignment.apidemo.model.Reverse;
import com.assignment.apidemo.service.StringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ApiDemoController {

    public static final String APPLICATION_JSON_VALUE = "application/json";
    public static final String INVALID_QUERY_MSG = "Query is invalid";
    public static final String INVALID_QUERY_DETAILS = "Query should be filled at least 2 symbols";

    private final StringService stringService;

    @Operation(summary = "Get reversed query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reversed query",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Reverse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid query", content = @Content)})
    @GetMapping(value = "/string", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Reverse> reverse(@RequestParam(value = "query") String query) {
        log.debug("Received query: " + query);
        require(query.trim().length() > 1, INVALID_QUERY_MSG,
                INVALID_QUERY_DETAILS);
        return ResponseEntity.ok(stringService.reverse(query));
    }

    private void require(boolean cond, String message, String details) {
        if (!cond) {
            throw new QueryException(message, details);
        }
    }
}
