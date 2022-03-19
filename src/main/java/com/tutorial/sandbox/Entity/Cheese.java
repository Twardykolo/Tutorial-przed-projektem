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
@Table(schema = "cheese", name = "Cheese")
public class Cheese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    @Column(nullable = false, name="nazwa")
    private String name;

    @Column(name="ilosc")
    private Integer amount;

    @Column(nullable = false,name = "czyZjedzon")
    private Boolean isNotEaten;

    @OneToOne
    @JoinColumn(name="szczur")
    private Rat ratto;

    @Column(name="creation_date")
    private Date creationDate;

}
