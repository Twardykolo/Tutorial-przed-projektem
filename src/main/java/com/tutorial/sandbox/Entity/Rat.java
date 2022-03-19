package com.tutorial.sandbox.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(schema = "rats", name = "Rat")
public class Rat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    @Column(nullable = false, name="imie")
    private String name;

    @Column(name="wiek")
    private Integer age;

    @Column(nullable = false,name = "czyzyje")
    private Boolean isAlive;

    @Column(name="creation_date")
    private Date creationDate;
}
