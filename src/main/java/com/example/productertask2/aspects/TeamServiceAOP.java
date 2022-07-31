package com.example.productertask2.aspects;

import com.example.productertask2.exception.CustomException;
import com.example.productertask2.repository.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class TeamServiceAOP {

    private final TeamRepository teamRepository;

    @Before("execution(* com.example.productertask2.business.concrete.TeamManager.*(..)) && args(teamId)")
    public void beforeControlTeamEntityIsPresent(Long teamId){
        boolean teamExists = teamRepository
                .findById(teamId)
                .isPresent();

        if(teamExists){
            return;
        }
        throw new CustomException(Constants.TEAM_NOT_FOUND);
    }
}
