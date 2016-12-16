package com.kpi.model;

import lombok.Data;

@Data
public class Agent {
    private Long id;
    private String name;
    private String address;
    private String bankDetails;
    private Integer restSugar;
    private Integer restBagasse;
}
