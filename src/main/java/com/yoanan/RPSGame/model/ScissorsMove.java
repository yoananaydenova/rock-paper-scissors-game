package com.yoanan.RPSGame.model;

// Demonstrate a Singleton design pattern, but the Spring way is with the @Bean annotation
//@Bean
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
