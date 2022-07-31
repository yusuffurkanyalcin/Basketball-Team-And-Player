package com.example.productertask2.business.abstracts;

import com.example.productertask2.core.result.DataResult;
import com.example.productertask2.core.result.Result;
import com.example.productertask2.dto.player.PlayerDTO;
import com.example.productertask2.dto.request.PlayerCreationRequest;
import com.example.productertask2.entity.player.PlayerEntity;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerDTO> getAll();

    Result remove(Long playerId);

    DataResult<PlayerDTO> createPlayer(PlayerCreationRequest request);

    Optional<PlayerEntity> getById(Long id);
}
