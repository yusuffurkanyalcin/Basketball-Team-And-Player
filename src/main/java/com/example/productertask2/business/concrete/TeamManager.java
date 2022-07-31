package com.example.productertask2.business.concrete;

import com.example.productertask2.business.abstracts.TeamService;
import com.example.productertask2.entity.team.TeamEntity;
import com.example.productertask2.repository.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamManager implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public boolean isTeamFull(Long teamId) {

        int playerSize = teamRepository
                .findById(teamId)
                .get()
                .getPlayerEntities()
                .size();

        if(playerSize >= 12){
            return true;
        }
        return false;
    }

    @Override
    public TeamEntity create(TeamEntity entity) {
        return teamRepository.save(entity);
    }

}
