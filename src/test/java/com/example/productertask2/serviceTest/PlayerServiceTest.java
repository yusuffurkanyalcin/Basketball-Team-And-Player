package com.example.productertask2.serviceTest;

import com.example.productertask2.business.concrete.PlayerManager;
import com.example.productertask2.business.concrete.TeamManager;
import com.example.productertask2.core.result.DataResult;
import com.example.productertask2.core.result.Result;
import com.example.productertask2.dto.mapper.PlayerMapperImp;
import com.example.productertask2.dto.player.PlayerDTO;
import com.example.productertask2.dto.request.PlayerCreationRequest;
import com.example.productertask2.entity.player.PlayerEntity;
import com.example.productertask2.entity.team.TeamEntity;
import com.example.productertask2.repository.player.PlayerRepository;
import com.example.productertask2.repository.team.TeamRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class PlayerServiceTest {
    private PlayerManager playerManager;
    private PlayerRepository playerRepository;
    private TeamManager teamManager;
    private TeamRepository teamRepository;
    private PlayerMapperImp playerMapperImp;

    PlayerDTO playerDTO;
    PlayerCreationRequest playerCreationRequest = new PlayerCreationRequest();

    DataResult<PlayerDTO> playerDTODataResult   = new DataResult<>();
    PlayerEntity playerEntity                   = new PlayerEntity();
    TeamEntity teamEntity                       = new TeamEntity();
    List<PlayerEntity> playerEntityList         = new ArrayList<>();
    List<PlayerDTO> playerDTOList               = new ArrayList<>();

    Optional<PlayerEntity> optionalPlayerEntity;

    @Before
    public void init(){
        playerRepository    = mock(PlayerRepository.class);
        teamRepository      = mock(TeamRepository.class);
        playerMapperImp     = mock(PlayerMapperImp.class);
        teamManager         = spy(new TeamManager(teamRepository));
        playerManager       = spy(new PlayerManager(playerRepository,teamManager,playerMapperImp));
    }

    @Test
    public void whenCreatePlayerCalledShouldReturnPlayerDTO() {

        initializeAddPlayerObjects();

        when(playerMapperImp.convertPlayerEntityToPlayerDTO(playerEntity)).thenReturn(playerDTO);

        doReturn(playerDTODataResult).when(playerManager).createPlayer(playerCreationRequest);

        DataResult<PlayerDTO> response = playerManager.createPlayer(playerCreationRequest);
        Assert.assertNotEquals("CreatePlayer results do not match !", playerDTODataResult, response.getData());

        playerMapperImp.convertPlayerEntityToPlayerDTO(playerEntity);

        verify(playerMapperImp).convertPlayerEntityToPlayerDTO(Mockito.any(PlayerEntity.class));
        verify(playerManager).createPlayer(playerCreationRequest);
    }
    @Test
    public void whenGetAllCalledShouldReturnPlayers() {

        initializeGetAllPlayers();

        when(playerRepository.getAll()).thenReturn(playerEntityList);
        when(playerMapperImp.convertPlayerEntityListToPlayerDTOList(playerEntityList)).thenReturn(playerDTOList);
        when(playerManager.getAll()).thenReturn(playerDTOList);

        List<PlayerDTO> result = playerManager.getAll();
        Assert.assertEquals("Lists Do Not Match !", result, playerDTOList);

        verify(playerMapperImp).convertPlayerEntityListToPlayerDTOList(playerEntityList);
    }
    @Test
    public void whenRemovePlayerCalled() {
        initializeAddPlayerObjects();

        Result processResult = playerManager.remove(Constants.PLAYER_ID);
        Assert.assertEquals(processResult, Result.successResult("Player has been deleted"));

        verify(this.playerManager).remove(Constants.PLAYER_ID);
    }

    @Test
    public void whenGetByIdCalledShouldReturnOptional(){
        Optional<PlayerEntity> expected = playerManager.getById(Constants.PLAYER_ID);
        Assert.assertNotSame("Get by id failured",expected,optionalPlayerEntity);
    }
    public void initializeAddPlayerObjects() {
        createPlayerEntity();

        playerCreationRequest.setName(Constants.PLAYER_NAME);
        playerCreationRequest.setSurname(Constants.PLAYER_SURNAME);
        playerCreationRequest.setPosition(Constants.PLAYER_POSITION);
        playerCreationRequest.setTeamId(Constants.TEAM_ID);

        createPlayerDTO();

        playerDTODataResult.setData(playerDTO);
        playerDTODataResult.setResult(Result.successResult("Add Player"));
    }
    public void initializeGetAllPlayers() {
        createPlayerEntity();
        playerEntityList.add(playerEntity);
    }
    public void createPlayerEntity() {

        createTeamEntity();
        playerEntity.setId(Constants.PLAYER_ID);
        playerEntity.setName(Constants.PLAYER_NAME);
        playerEntity.setSurname(Constants.PLAYER_SURNAME);
        playerEntity.setPosition(Constants.PLAYER_POSITION.toString());
        playerEntity.setTeamEntity(teamEntity);
    }
    private void createPlayerDTO() {
        playerDTO = PlayerDTO.builder()
                .id(Constants.PLAYER_ID)
                .name(Constants.PLAYER_NAME)
                .surname(Constants.PLAYER_SURNAME)
                .team(teamEntity.getName())
                .position(Constants.PLAYER_POSITION.toString())
                .build();
    }
    private void createTeamEntity(){
        teamEntity.setId(Constants.TEAM_ID);
        teamEntity.setName("Trabzon");
    }
}
