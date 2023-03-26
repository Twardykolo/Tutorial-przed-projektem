package com.tutorial.sandbox.DTO.Response;

import com.tutorial.sandbox.Entity.Rats.Cat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatResponse {
    private long id;
    private String name;
    private int age;
    private int numberOfRats;

    private Date creationDate;

    public CatResponse(Cat cat){
        this.id = cat.getId();
        this.name = cat.getName();
        this.age = cat.getAge();
        this.numberOfRats = cat.getNumberOfRats();
        this.creationDate = cat.getCreationDate();
    }
}
