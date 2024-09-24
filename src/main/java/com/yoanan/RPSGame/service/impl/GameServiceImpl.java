package com.yoanan.RPSGame.service.impl;

import com.yoanan.RPSGame.dto.ResultGameDto;
import com.yoanan.RPSGame.exception.NoSuchGameException;
import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.dto.MoveDto;
import com.yoanan.RPSGame.exception.NoSuchMoveException;
import com.yoanan.RPSGame.exception.NoSuchPlayerException;
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

        final Game game = getGame(moveDto.getGameId());

        if (game.isFinished()) {
            throw new NoSuchMoveException("This game is finished! Create another game!");
        }

        final Player winner = this.winnerCalculator.calculateMoveWinner(moveDto.getMove().trim());

        final Game savedGame = saveScoreInGame(game, winner);

        return new ResultGameDto()
                .setMoveWinner(winner)
                .setAttempts(savedGame.getAttempts())
                .setCurrentAttempt(savedGame.getCurrentAttempt())
                .setUserScore(savedGame.getUserScore())
                .setComputerScore(savedGame.getComputerScore())
                .setDrawScore(savedGame.getDrawScore());

    }

    @Override
    public ResultGameDto stopGame(Long gameId) {

        final Game game = getGame(gameId);

        if (game.isFinished()) {
            throw new NoSuchMoveException("This game is finished! To make a move - create another game!");
        }
        game.setFinished(true);
        saveGame(game);

        final Player winner = calculateGameWinner(game);

        return new ResultGameDto()
                .setGameWinner(winner)
                .setFinished(game.isFinished())
                .setAttempts(game.getAttempts())
                .setCurrentAttempt(game.getCurrentAttempt())
                .setUserScore(game.getUserScore())
                .setComputerScore(game.getComputerScore())
                .setDrawScore(game.getDrawScore());
    }

    @Override
    public ResultGameDto findGame(Long gameId) {
        final Game game = getGame(gameId);

        final Player winner = calculateGameWinner(game);

        return new ResultGameDto()
                .setGameWinner(winner)
                .setFinished(game.isFinished())
                .setAttempts(game.getAttempts())
                .setCurrentAttempt(game.getCurrentAttempt())
                .setUserScore(game.getUserScore())
                .setComputerScore(game.getComputerScore())
                .setDrawScore(game.getDrawScore());
    }

    private static Player calculateGameWinner(Game game) {

        final int userScore = game.getUserScore();
        final int computerScore = game.getComputerScore();
        return userScore == computerScore
                ? Player.DRAW
                : (userScore > computerScore ? Player.USER : Player.COMPUTER);
    }

    private Game saveScoreInGame(Game game, Player winner) {

        switch (winner) {
            case USER -> game.increaseUserScore();
            case COMPUTER -> game.increaseComputerScore();
            case DRAW -> game.increaseDrawScore();
            default -> throw new NoSuchPlayerException(String.format("Player %s doesn't exist!", winner));
        }

        game.increaseCurrentAttempt();
        if (game.getAttempts() == game.getCurrentAttempt()) {
            game.setFinished(true);
        }
        return saveGame(game);
    }

    private Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    private Game getGame(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(NoSuchGameException::new);
    }


}
