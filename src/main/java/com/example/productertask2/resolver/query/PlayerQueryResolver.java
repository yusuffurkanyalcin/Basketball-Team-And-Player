package com.example.productertask2.resolver.query;

import com.example.productertask2.business.abstracts.PlayerService;
import com.example.productertask2.dto.player.PlayerDTO;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerService playerService;

    public List<PlayerDTO> getAll(){
        return playerService.getAll();
    }
}
