package com.example.demo04.model.dto.reponse;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiDataRepose<T> {
    private boolean success;
    private String message;
    private T data;
    private HttpStatus httpStatus;
}