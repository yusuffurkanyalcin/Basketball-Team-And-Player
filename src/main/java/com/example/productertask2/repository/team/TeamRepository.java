package com.example.productertask2.repository.team;

import com.example.productertask2.entity.team.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity,Long> {
}
