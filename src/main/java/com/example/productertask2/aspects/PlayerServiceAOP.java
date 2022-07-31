package com.example.productertask2.aspects;

import com.example.productertask2.exception.CustomException;
import com.example.productertask2.repository.player.PlayerRepository;
import com.example.productertask2.repository.team.TeamRepository;
import graphql.GraphQLException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class PlayerServiceAOP {

    private final PlayerRepository playerRepository;

    @Before("execution(* com.example.productertask2.business.concrete.PlayerManager.remove(..))")
    public void beforeControlTeamEntityIsPresent(JoinPoint point){
        Long playerId = (Long) point.getArgs()[0];
        boolean playerExists = playerRepository
                .findById(playerId)
                .isPresent();

        if(playerExists){
            return;
        }
        throw new CustomException(Constants.PLAYER_NOT_FOUND);
    }
}
