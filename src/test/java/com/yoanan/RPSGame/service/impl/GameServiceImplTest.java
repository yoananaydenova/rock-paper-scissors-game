package com.yoanan.RPSGame.service.impl;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.dto.MoveDto;
import com.yoanan.RPSGame.dto.ResultGameDto;
import com.yoanan.RPSGame.exception.NoSuchGameException;
import com.yoanan.RPSGame.mapper.GameMapper;
import com.yoanan.RPSGame.model.Game;
import com.yoanan.RPSGame.model.Player;
import com.yoanan.RPSGame.repository.GameRepository;
import com.yoanan.RPSGame.service.MoveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameServiceImplTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private GameMapper gameMapper;

    @Mock
    private MoveService moveService;

    @InjectMocks
    private GameServiceImpl gameServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateGame() {
        Game game = new Game(3);
        GameDto gameDto = new GameDto();

        when(gameRepository.save(any(Game.class))).thenReturn(game);
        when(gameMapper.toItemDto(game)).thenReturn(gameDto);

        GameDto result = gameServiceImpl.createGame(3);

        assertNotNull(result);
        verify(gameRepository).save(any(Game.class));
        verify(gameMapper).toItemDto(game);
    }

    // TODO fix code and test
    @Disabled
    @Test
    public void testPlayGame() {
        Game game = new Game(3);
        game.setCurrentAttempt(1);

        MoveDto moveDto = new MoveDto();
        moveDto.setGameId(1L);
        moveDto.setMove("rock");

        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));
        when(moveService.calculateMoveWinner("rock")).thenReturn(Player.USER);

        ResultGameDto result = gameServiceImpl.playGame(moveDto);

        assertNotNull(result);
        assertEquals(Player.USER, result.getMoveWinner());
        verify(gameRepository).save(game);
    }

    @Test
    public void testStopGame() {
        Game game = new Game(3);
        game.setCurrentAttempt(1);

        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));

        ResultGameDto result = gameServiceImpl.stopGame(1L);

        assertNotNull(result);
        assertTrue(result.isFinished());
        verify(gameRepository).save(game);
    }

    @Test
    public void testFindGameThrowsException() {
        when(gameRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchGameException.class, () -> gameServiceImpl.findGame(1L));
    }
}

