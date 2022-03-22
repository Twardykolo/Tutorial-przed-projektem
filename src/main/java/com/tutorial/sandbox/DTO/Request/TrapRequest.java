package com.tutorial.sandbox.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrapRequest {
    private Double xVal;
    private Double yVal;
    @NotNull
    private Boolean isTaken;
}
