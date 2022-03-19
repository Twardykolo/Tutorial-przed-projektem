package com.tutorial.sandbox.DTO.Request;

import com.tutorial.sandbox.Entity.Rat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheeseRequest {
    @NotNull
    private String name;

    private Integer amount;

    private Boolean isNotEaten;

    private Rat ratto;
}