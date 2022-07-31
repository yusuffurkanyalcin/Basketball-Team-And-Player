package com.example.productertask2.business.concrete;

import com.example.productertask2.business.Constants;
import com.example.productertask2.business.abstracts.PlayerService;
import com.example.productertask2.business.abstracts.TeamService;
import com.example.productertask2.core.result.DataResult;
import com.example.productertask2.core.result.Result;
import com.example.productertask2.dto.mapper.PlayerMapper;
import com.example.productertask2.dto.player.PlayerDTO;
import com.example.productertask2.dto.request.PlayerCreationRequest;
import com.example.productertask2.entity.player.PlayerEntity;
import com.example.productertask2.repository.player.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class PlayerManager implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamService teamService;
    private final PlayerMapper playerMapper;

    @Override
    public List<PlayerDTO> getAll() {
        return Optional.ofNullable(
                playerRepository.getAll())
                .map(playerMapper::convertPlayerEntityListToPlayerDTOList)
                .orElse(null);
    }

    @Override
    public Result remove(Long playerId) {

        playerRepository.deleteById(playerId);
        return Result.successResult(Constants.PLAYER_HAS_BEEN_DELETED);
    }

    @Override
    public DataResult<PlayerDTO> createPlayer(PlayerCreationRequest request) {

        PlayerEntity playerEntity = playerMapper.convertFromDTOtoEntity(request);

        PlayerEntity response = playerRepository.save(playerEntity);

        PlayerDTO playerDTO = playerMapper.convertPlayerEntityToPlayerDTO(response);

        return new DataResult<>(
                playerDTO,
                Result.successResult(Constants.PLAYER_ADDED)
        );
    }

    @Override
    public Optional<PlayerEntity> getById(Long id) {
        return playerRepository.findById(id);
    }

}
