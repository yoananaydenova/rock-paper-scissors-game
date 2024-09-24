package com.yoanan.RPSGame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yoanan.RPSGame.model.Player;

public class ResultGameDto {

    @JsonProperty("move-winner")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Player moveWinner;

    @JsonProperty("game-winner")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Player gameWinner;

    private int attempts;

    @JsonProperty("current-attempt")
    private int currentAttempt;

    @JsonProperty("user-score")
    private int userScore;

    @JsonProperty("computer-score")
    private int computerScore;

    @JsonProperty("draw-score")
    private int drawScore;

    @JsonProperty("finished")
    private boolean isFinished;

    public ResultGameDto() {
    }

    public Player getMoveWinner() {
        return moveWinner;
    }

    public ResultGameDto setMoveWinner(Player moveWinner) {
        this.moveWinner = moveWinner;
        return this;
    }

    public Player getGameWinner() {
        return gameWinner;
    }

    public ResultGameDto setGameWinner(Player gameWinner) {
        this.gameWinner = gameWinner;
        return this;
    }

    public int getAttempts() {
        return attempts;
    }

    public ResultGameDto setAttempts(int attempts) {
        this.attempts = attempts;
        return this;
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public ResultGameDto setCurrentAttempt(int currentAttempt) {
        this.currentAttempt = currentAttempt;
        return this;
    }

    public int getUserScore() {
        return userScore;
    }

    public ResultGameDto setUserScore(int userScore) {
        this.userScore = userScore;
        return this;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public ResultGameDto setComputerScore(int computerScore) {
        this.computerScore = computerScore;
        return this;
    }

    public int getDrawScore() {
        return drawScore;
    }

    public ResultGameDto setDrawScore(int drawScore) {
        this.drawScore = drawScore;
        return this;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public ResultGameDto setFinished(boolean finished) {
        isFinished = finished;
        return this;
    }
}
