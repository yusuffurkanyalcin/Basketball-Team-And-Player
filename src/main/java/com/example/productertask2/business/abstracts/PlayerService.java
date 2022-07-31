package com.example.productertask2.business.abstracts;

import com.example.productertask2.core.result.DataResult;
import com.example.productertask2.core.result.Result;
import com.example.productertask2.dto.player.PlayerDTO;
import com.example.productertask2.dto.request.PlayerCreationRequest;

import java.util.List;

public interface PlayerService {
    List<PlayerDTO> getAll();

    Result remove(Long playerId);

    DataResult<PlayerDTO> createPlayer(PlayerCreationRequest request);
}
