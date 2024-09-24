package com.yoanan.RPSGame.model;
// Demonstrate a Singleton design pattern, but the Spring way is with the @Bean annotation
//@Bean
public class PaperMove implements GameMove {

    public static final String MOVE_NAME = "paper";
    private static final GameMove instance = new PaperMove();
    private static final GameMove defeatedBy = ScissorsMove.getInstance();

    private PaperMove() {
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
