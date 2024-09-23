package com.yoanan.RPSGame.service.impl;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.mapper.GameMapper;
import com.yoanan.RPSGame.model.Game;
import com.yoanan.RPSGame.repository.GameRepository;
import com.yoanan.RPSGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    @Override
    public GameDto createGame(Integer attempts) {
        final Game newGame = gameRepository.save(new Game(attempts));
        return gameMapper.toItemDto(newGame);
    }
}
