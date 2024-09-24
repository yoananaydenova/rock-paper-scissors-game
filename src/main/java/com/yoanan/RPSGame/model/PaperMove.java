package com.yoanan.RPSGame.model;

public class PaperMove implements GameMove {

    public static final String MOVE_NAME = "paper";
    private static final GameMove instance = new PaperMove();
    private static final GameMove defeatedBy = ScissorsMove.getInstance();
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
