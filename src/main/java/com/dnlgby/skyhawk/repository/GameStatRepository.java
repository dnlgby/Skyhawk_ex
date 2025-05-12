package com.dnlgby.skyhawk.repository;

import com.dnlgby.skyhawk.dto.StatsResponse;
import com.dnlgby.skyhawk.entity.GameStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameStatRepository extends JpaRepository<GameStat, Long> {

    @Query("""
        SELECT new com.dnlgby.skyhawk.dto.StatsResponse(
            AVG(g.points), AVG(g.rebounds), AVG(g.assists),
            AVG(g.steals), AVG(g.blocks), AVG(g.fouls),
            AVG(g.turnovers), AVG(g.minutesPlayed)
        )
        FROM GameStat g
        WHERE g.player.id = :playerId
    """)
    StatsResponse findAveragesByPlayerId(@Param("playerId") Long playerId);

    @Query("""
        SELECT new com.dnlgby.skyhawk.dto.StatsResponse(
            AVG(g.points), AVG(g.rebounds), AVG(g.assists),
            AVG(g.steals), AVG(g.blocks), AVG(g.fouls),
            AVG(g.turnovers), AVG(g.minutesPlayed)
        )
        FROM GameStat g
        WHERE g.player.team.id = :teamId
    """)
    StatsResponse findAveragesByTeamId(@Param("teamId") Long teamId);
}
