package com.bmk.nexus.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    private String message;

    private Map<String, String> errors;
}
