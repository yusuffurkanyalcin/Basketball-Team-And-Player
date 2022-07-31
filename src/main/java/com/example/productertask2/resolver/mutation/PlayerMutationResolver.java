package com.example.productertask2.resolver.mutation;

import com.example.productertask2.business.abstracts.PlayerService;
import com.example.productertask2.core.result.DataResult;
import com.example.productertask2.core.result.Result;
import com.example.productertask2.dto.player.PlayerDTO;
import com.example.productertask2.dto.request.PlayerCreationRequest;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {
    private final PlayerService playerService;

    public Result removePlayer(Long playerId) {
        return playerService.remove(playerId);
    }

    public DataResult<PlayerDTO> createPlayer(PlayerCreationRequest request){
        return playerService.createPlayer(request);
    }
}
