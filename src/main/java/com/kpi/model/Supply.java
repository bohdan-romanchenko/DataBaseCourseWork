package com.kpi.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Supply {

    private Long id;
    private Date billDate;
    private Integer beetEstimated;
    private Integer sugarEstimated;
    private Integer bagasseEstimated;
    private Long agent;

}
