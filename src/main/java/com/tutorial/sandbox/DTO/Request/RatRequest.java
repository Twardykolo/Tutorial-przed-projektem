package com.tutorial.sandbox.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RatRequest {
    @NotNull
    private String name;

    private Integer age;

    private Boolean isAlive;
}
