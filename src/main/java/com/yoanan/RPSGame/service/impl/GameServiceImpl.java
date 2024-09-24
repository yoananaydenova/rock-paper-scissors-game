package com.yoanan.RPSGame.service.impl;

import com.yoanan.RPSGame.dto.ResultGameDto;
import com.yoanan.RPSGame.exception.NoSuchGameException;
import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.dto.MoveDto;
import com.yoanan.RPSGame.mapper.GameMapper;
import com.yoanan.RPSGame.model.*;
import com.yoanan.RPSGame.repository.GameRepository;
import com.yoanan.RPSGame.service.GameService;
import com.yoanan.RPSGame.service.WinnerCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final WinnerCalculatorService winnerCalculator;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository, GameMapper gameMapper, WinnerCalculatorService winnerCalculator) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
        this.winnerCalculator = winnerCalculator;
    }

    @Override
    public GameDto createGame(Integer attempts) {
        final Game newGame = saveGame(new Game(attempts));
        return gameMapper.toItemDto(newGame);
    }

    @Override
    public ResultGameDto playGame(MoveDto moveDto) {

        final Player winner = calculateWinner(moveDto);

        final Game game = saveScoreInGame(moveDto.getGameId(), winner);

        return new ResultGameDto(winner, game.getUserScore(), game.getComputerScore(), game.getDrawScore());
    }

    @Override
    public ResultGameDto stopGame(Long gameId) {

        final Game game = getGame(gameId);

        // TODO
        return null;
    }

    private Player calculateWinner(MoveDto moveDto) {
        final GameMove playerMove = WinnerCalculatorServiceImpl.getMove(moveDto.getMove().trim());
        this.winnerCalculator.setPlayerMove(playerMove);

        final GameMove computerMove = WinnerCalculatorServiceImpl.generateComputerMove();
        this.winnerCalculator.setComputerMove(computerMove);

        return this.winnerCalculator.calculateWinner();
    }

    private Game saveScoreInGame(Long gameId, Player winner) {
        final Game game = getGame(gameId);
        if (Player.USER.equals(winner)) {
            game.setUserScore(game.getUserScore() + 1);
        }
        if (Player.COMPUTER.equals(winner)) {
            game.setComputerScore(game.getComputerScore() + 1);
        }
        if (Player.DRAW.equals(winner)) {
            game.setDrawScore(game.getComputerScore() + 1);
        }

        return saveGame(game);
    }

    private Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    private Game getGame(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new NoSuchGameException("The game should exist!"));
    }


}
