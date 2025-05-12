package com.dnlgby.skyhawk.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerStatsRequest {
    private Long playerId;
    private LocalDate gameDate;
    private int points, rebounds, assists, steals, blocks, fouls, turnovers;
    private float minutesPlayed;
}