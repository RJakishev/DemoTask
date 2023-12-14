package com.demotask.decathlon.dto;

import lombok.Data;

@Data
public class ResultDTO{
    private int id;
    private Integer eventId;
    private Double points;
    private Double eventResult;
    private Integer athletId;
}