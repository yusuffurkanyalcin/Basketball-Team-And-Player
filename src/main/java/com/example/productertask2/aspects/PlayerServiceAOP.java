package com.example.productertask2.aspects;

import com.example.productertask2.business.abstracts.PlayerService;
import com.example.productertask2.business.abstracts.TeamService;
import com.example.productertask2.core.result.DataResult;
import com.example.productertask2.core.result.Result;
import com.example.productertask2.dto.request.PlayerCreationRequest;
import com.example.productertask2.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
@RequiredArgsConstructor
public class PlayerServiceAOP {

    private final PlayerService playerService;
    private final TeamService teamService;

    @Before("execution(* com.example.productertask2.business.concrete.PlayerManager.remove(..))")
    public void beforeControlTeamEntityIsPresent(JoinPoint joinPoint){
        Long playerId = (Long) joinPoint.getArgs()[0];
        boolean playerExists = playerService
                .getById(playerId)
                .isPresent();

        if(playerExists){
            return;
        }
        throw new CustomException(Constants.PLAYER_NOT_FOUND);
    }

    @Before("execution(* com.example.productertask2.business.concrete.PlayerManager.createPlayer(..)) && args(request)")
    public void beforeControlPlayerAdding(PlayerCreationRequest request){

        Long teamId = request.getTeamId();

        boolean isTeamFull = teamService.isTeamFull(teamId);

        if(isTeamFull){
            throw new CustomException(Constants.TEAM_FULL);
        }
         return;
    }
}
