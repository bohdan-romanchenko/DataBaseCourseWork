package com.kpi.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Shipment {

    private Long id;
    private Date billDate;
    private Integer sugarShipped;
    private Integer bagasseShipped;
    private Long supply;
    private Long agent;

}
