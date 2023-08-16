package com.example.cicddemo.error;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus httpStatus,String errorMessage) {
}
