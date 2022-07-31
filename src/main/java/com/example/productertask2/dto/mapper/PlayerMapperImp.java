package com.example.productertask2.dto.mapper;

import com.example.productertask2.dto.player.PlayerDTO;
import com.example.productertask2.dto.request.PlayerCreationRequest;
import com.example.productertask2.entity.player.PlayerEntity;
import com.example.productertask2.entity.team.TeamEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerMapperImp implements PlayerMapper{

    @Override
    public List<PlayerDTO> convertPlayerEntityListToPlayerDTOList(List<PlayerEntity> playerEntities){
        List<PlayerDTO> targetList = new ArrayList<>();
        for( PlayerEntity playerEntity : playerEntities){
            targetList.add(
                    PlayerDTO.builder()
                            .id(playerEntity.getId())
                            .name(playerEntity.getName())
                            .surname(playerEntity.getSurname())
                            .team(playerEntity.getTeamEntity().getName())
                            .position(playerEntity.getPosition())
                            .createdAt(playerEntity.getCreatedAt().toString())
                            .build()
            );
        }
        return targetList;
    }

    @Override
    public PlayerDTO convertPlayerEntityToPlayerDTO(PlayerEntity playerEntity) {
        return PlayerDTO.builder()
                .id(playerEntity.getId())
                .name(playerEntity.getName())
                .surname(playerEntity.getSurname())
                .team(playerEntity.getTeamEntity().getName())
                .position(playerEntity.getPosition())
                .createdAt(playerEntity.getCreatedAt().toString())
                .build();
    }

    public PlayerEntity convertFromDTOtoEntity(PlayerCreationRequest request){
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(request.getTeamId());

        PlayerEntity playerEntity = new PlayerEntity(
                request.getName(),
                request.getSurname(),
                request.getPosition().toString(),
                teamEntity
        );

        return playerEntity;
    }
}
