package com.yoanan.RPSGame.service.impl;

import com.yoanan.RPSGame.exception.NoSuchMoveException;
import com.yoanan.RPSGame.model.*;
import com.yoanan.RPSGame.service.MoveService;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Random;


@Service
public class MoveServiceImpl implements MoveService {
    private static final Map<String, GameMove> gameMoves = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("1", RockMove.getInstance()),
            new AbstractMap.SimpleEntry<>("2", PaperMove.getInstance()),
            new AbstractMap.SimpleEntry<>("3", ScissorsMove.getInstance()),

            new AbstractMap.SimpleEntry<>("rock", RockMove.getInstance()),
            new AbstractMap.SimpleEntry<>("paper", PaperMove.getInstance()),
            new AbstractMap.SimpleEntry<>("scissors", ScissorsMove.getInstance())
    );

    private static final int RANDOM_LOWER_BOUND = 1;
    private static final int RANDOM_UPPER_BOUND = gameMoves.size() / 2 + 1;

    private GameMove computerMove = RockMove.getInstance();
    private GameMove userMove = RockMove.getInstance();

    public MoveServiceImpl() {
    }

    public static GameMove generateComputerMove() {
        return getMove(String.valueOf(generateMoveCode()));
    }


    public void setComputerMove(GameMove computerMove) {
        this.computerMove = computerMove;
    }


    public void setUserMove(GameMove userMove) {
        this.userMove = userMove;
    }

    public static GameMove getMove(String move) {

        if (!MoveServiceImpl.gameMoves.containsKey(move)) {
            throw new NoSuchMoveException("Game move should exist!");
        }
        return MoveServiceImpl.gameMoves.get(move);
    }

    public Player calculateMoveWinner(String userMoveStr) {
        final GameMove userMove = getMove(userMoveStr);
        setUserMove(userMove);

        final GameMove computerMove = generateComputerMove();
        setComputerMove(computerMove);

        return calculateWinner();
    }

    private Player calculateWinner() {
        if (computerMove.equals(userMove)) {
            return Player.DRAW;
        }

        if (computerMove.defeatedBy().equals(userMove)) {
            return Player.USER;
        }

        return Player.COMPUTER;
    }

    private static int generateMoveCode() {
        final Random random = new Random();
        return random.ints(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND)
                .findFirst()
                .orElseThrow(() -> new NoSuchMoveException("The generated move code should exist!"));
    }
}
