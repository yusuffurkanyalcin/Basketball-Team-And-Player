package com.example.productertask2.business.abstracts;


import com.example.productertask2.entity.team.TeamEntity;

import java.util.Optional;

public interface TeamService {
    boolean isTeamFull(Long teamId);
    TeamEntity create(TeamEntity entity);
    Optional<TeamEntity> getById(Long id);
}
