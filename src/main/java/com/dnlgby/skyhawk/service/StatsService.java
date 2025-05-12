package com.dnlgby.skyhawk.service;

import com.dnlgby.skyhawk.dto.PlayerStatsRequest;
import com.dnlgby.skyhawk.dto.StatsResponse;
import com.dnlgby.skyhawk.entity.GameStat;
import com.dnlgby.skyhawk.entity.Player;
import com.dnlgby.skyhawk.exception.PlayerNotFoundException;
import com.dnlgby.skyhawk.repository.GameStatRepository;
import com.dnlgby.skyhawk.repository.PlayerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    private final GameStatRepository gameStatRepository;
    private final PlayerRepository playerRepository;

    public StatsService(GameStatRepository gameStatRepository, PlayerRepository playerRepository) {
        this.gameStatRepository = gameStatRepository;
        this.playerRepository = playerRepository;
    }

    public void saveStats(List<PlayerStatsRequest> statsList) {
        for (PlayerStatsRequest s : statsList) {
            Player player = playerRepository.findById(s.getPlayerId())
                    .orElseThrow(() -> new PlayerNotFoundException(s.getPlayerId()));

            GameStat stat = GameStat.builder()
                    .player(player)
                    .gameDate(s.getGameDate())
                    .points(s.getPoints())
                    .rebounds(s.getRebounds())
                    .assists(s.getAssists())
                    .steals(s.getSteals())
                    .blocks(s.getBlocks())
                    .fouls(s.getFouls())
                    .turnovers(s.getTurnovers())
                    .minutesPlayed(s.getMinutesPlayed())
                    .build();

            gameStatRepository.save(stat);
        }
    }

    @Cacheable(value = "playerAverages", key = "#playerId")
    public StatsResponse getPlayerAverages(Long playerId) {
        return gameStatRepository.findAveragesByPlayerId(playerId);
    }

    @Cacheable(value = "teamAverages", key = "#teamId")
    public StatsResponse getTeamAverages(Long teamId) {
        return gameStatRepository.findAveragesByTeamId(teamId);
    }
}
