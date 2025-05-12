package com.dnlgby.skyhawk.controller;

import com.dnlgby.skyhawk.dto.PlayerStatsRequest;
import com.dnlgby.skyhawk.dto.StatsResponse;
import com.dnlgby.skyhawk.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @PostMapping("/stats")
    public void logStats(@RequestBody List<PlayerStatsRequest> stats) {
        statsService.saveStats(stats);
    }

    @GetMapping("/players/{id}/averages")
    public StatsResponse getPlayerAvg(@PathVariable Long id) {
        return statsService.getPlayerAverages(id);
    }

    @GetMapping("/teams/{id}/averages")
    public StatsResponse getTeamAvg(@PathVariable Long id) {
        return statsService.getTeamAverages(id);
    }
}
