package com.tutorial.sandbox.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CatRequest {
    @NotNull
    private String name;

    private Integer age;

    private Integer numberOfRats;
}
