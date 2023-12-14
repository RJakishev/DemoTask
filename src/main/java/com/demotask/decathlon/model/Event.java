package com.demotask.decathlon.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double a;
    private double b;
    private double c;
    private boolean isDistanceUnit;

    @OneToMany(mappedBy = "event")
    private List<Result> results;
}
