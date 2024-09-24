package com.yoanan.RPSGame.service.impl;

import com.yoanan.RPSGame.exception.NoSuchMoveException;
import com.yoanan.RPSGame.model.*;
import com.yoanan.RPSGame.service.WinnerCalculatorService;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Random;


@Service
public class WinnerCalculatorServiceImpl implements WinnerCalculatorService {
    public static final Map<String, GameMove> gameMoves = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("1", RockMove.getInstance()),
            new AbstractMap.SimpleEntry<>("2", PaperMove.getInstance()),
            new AbstractMap.SimpleEntry<>("3", ScissorsMove.getInstance()),

            new AbstractMap.SimpleEntry<>("rock", RockMove.getInstance()),
            new AbstractMap.SimpleEntry<>("paper", PaperMove.getInstance()),
            new AbstractMap.SimpleEntry<>("scissors", ScissorsMove.getInstance())
    );

    private GameMove computerMove = RockMove.getInstance();
    private GameMove playerMove = RockMove.getInstance();

    public WinnerCalculatorServiceImpl() {
    }

    public static GameMove generateComputerMove() {
        return getMove(String.valueOf(generateMoveCode()));
    }


    public void setComputerMove(GameMove computerMove) {
        this.computerMove = computerMove;
    }


    public void setPlayerMove(GameMove playerMove) {
        this.playerMove = playerMove;
    }

    public Player calculateWinner() {
        // totalNumberGames-;
        if (computerMove.equals(playerMove)) {
//            return String.format("Draw! Computer: %s, Player: %s", computerMove, playerMove);
            return Player.DRAW;
        }

        if (computerMove.defeatedBy().equals(playerMove)) {
//            return String.format("Player win! Computer: %s, Player: %s", computerMove, playerMove);
            return Player.USER;
        }

//        return String.format("Player loss! Computer: %s, Player: %s", computerMove, playerMove);
        return Player.COMPUTER;
    }

    public static GameMove getMove(String move) {

        if (!WinnerCalculatorServiceImpl.gameMoves.containsKey(move)) {
            throw new NoSuchMoveException("Game move should exist!");
        }
        return WinnerCalculatorServiceImpl.gameMoves.get(move);
    }

    private static int generateMoveCode() {
        final Random random = new Random();
        return random.ints(1, 4)
                .findFirst()
                .orElseThrow(() -> new NoSuchMoveException("The generated move code should exist!"));
    }
}
