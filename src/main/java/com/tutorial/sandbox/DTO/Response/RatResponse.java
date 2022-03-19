package com.tutorial.sandbox.DTO.Response;

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
public class RatResponse {
    private Long id;
    private String name;
    private Boolean isAlive;
    private Integer age;
    private Date creationDate;

    public RatResponse(Rat rat){
        this.id= rat.getId();
        this.name= rat.getName();
        this.isAlive=rat.getIsAlive();
        this.age= rat.getAge();
        this.creationDate=rat.getCreationDate();
    }
}
