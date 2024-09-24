package com.yoanan.RPSGame.model;

public class ScissorsMove implements GameMove {

    public static final String MOVE_NAME = "scissors";
    private static final GameMove instance = new ScissorsMove();
    private static final GameMove defeatedBy = RockMove.getInstance();

    private ScissorsMove() {
    }
    public static GameMove getInstance() {
        return instance;
    }

    @Override
    public GameMove defeatedBy() {
        return defeatedBy;
    }

    @Override
    public String toString() {
        return MOVE_NAME;
    }
}
