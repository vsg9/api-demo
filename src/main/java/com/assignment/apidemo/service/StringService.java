package com.assignment.apidemo.service;

import com.assignment.apidemo.model.Reverse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class StringService {

    public Reverse reverse(String query) {
        return Reverse.builder()
                .result(StringUtils.reverse(query))
                .build();
    }
}
