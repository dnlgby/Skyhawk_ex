package com.dnlgby.skyhawk.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GameStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private LocalDate gameDate;

    private int points, rebounds, assists, steals, blocks, turnovers, fouls;
    private float minutesPlayed;
}
