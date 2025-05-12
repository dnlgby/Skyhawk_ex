package com.dnlgby.skyhawk.repository;


import com.dnlgby.skyhawk.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
