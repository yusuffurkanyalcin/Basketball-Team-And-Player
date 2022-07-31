package com.example.productertask2.business.abstracts;


import com.example.productertask2.entity.team.TeamEntity;

public interface TeamService {
    boolean isTeamFull(Long teamId);
    TeamEntity create(TeamEntity entity);
}
