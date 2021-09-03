package com.assignment.apidemo.exception;

import lombok.Getter;

@Getter
public class QueryException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String summary;
    private final String details;

    public QueryException(String summary, String details) {
        super(summary);
        this.summary = summary;
        this.details = details;
    }

}
