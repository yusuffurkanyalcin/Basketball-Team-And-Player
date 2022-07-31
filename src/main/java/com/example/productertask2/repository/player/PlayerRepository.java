package com.example.productertask2.repository.player;

import com.example.productertask2.entity.player.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {

    @Query("SELECT player FROM PlayerEntity player INNER JOIN player.teamEntity team")
    List<PlayerEntity> getAll();
}
