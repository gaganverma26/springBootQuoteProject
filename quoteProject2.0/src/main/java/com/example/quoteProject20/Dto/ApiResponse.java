package com.example.quoteProject20.Dto;

import java.util.List;

public record ApiResponse( int status, boolean success, String message, List<?> results) {
}
