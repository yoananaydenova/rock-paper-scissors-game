package com.yoanan.RPSGame.model;

public class RockMove implements GameMove {

    public static final String MOVE_NAME = "rock";
    private static final GameMove instance = new RockMove();
    private static final GameMove defeatedBy = PaperMove.getInstance();

    private RockMove() {
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
