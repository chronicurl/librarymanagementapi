package com.library.managementapi.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;


@Data
public class LoanRequest {

    @NotNull(message = "borrowerId is required")
    private Long borrowerId;

    @NotNull(message = "bookId is required")
    private Long bookId;
}