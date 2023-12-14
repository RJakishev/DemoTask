package com.demotask.decathlon.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private Double points;

    private Double eventResult;

    @ManyToOne
    @JoinColumn(name = "athlet_id")
    private Athlet athlet;
}
