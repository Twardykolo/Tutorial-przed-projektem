package com.tutorial.sandbox.Entity.Rats;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(schema = "traps", name = "Trap")
public class Trap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable=false)
    private Long id;

    @Column(nullable = false, name="czyzajeta")
    private Boolean isTaken;

    @Column(name="catchDate")
    private Date catchDate;

    @Column(name="xVal")
    private Double xVal;

    @Column(name="yVal")
    private Double yVal;
}
