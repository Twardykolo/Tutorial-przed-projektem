package com.tutorial.sandbox.DTO.Response;

import com.tutorial.sandbox.Entity.Cheese;
import com.tutorial.sandbox.Entity.Rat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheeseResponse {
    private Long id;
    private String name;
    private Boolean isEaten;
    private Integer amount;
    private Rat ratto;
    private Date creationDate;

    public CheeseResponse(Cheese cheese){
        this.id= cheese.getId();
        this.name= cheese.getName();
        this.isEaten=cheese.getIsNotEaten();
        this.amount= cheese.getAmount();
        this.ratto= cheese.getRatto();
        this.creationDate=cheese.getCreationDate();
    }
}