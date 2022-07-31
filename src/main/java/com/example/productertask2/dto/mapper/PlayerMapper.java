package com.example.productertask2.dto.mapper;

import com.example.productertask2.dto.player.PlayerDTO;
import com.example.productertask2.dto.request.PlayerCreationRequest;
import com.example.productertask2.entity.player.PlayerEntity;
import java.util.List;

public interface PlayerMapper {

    List<PlayerDTO> convertPlayerEntityListToPlayerDTOList(List<PlayerEntity> playerEntities);
    PlayerDTO convertPlayerEntityToPlayerDTO(PlayerEntity playerEntity);

    PlayerEntity convertFromDTOtoEntity(PlayerCreationRequest request);
}
