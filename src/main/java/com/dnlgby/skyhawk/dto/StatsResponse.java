package com.dnlgby.skyhawk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StatsResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double points;
    private Double rebounds;
    private Double assists;
    private Double steals;
    private Double blocks;
    private Double fouls;
    private Double turnovers;
    private Double minutesPlayed;
}
