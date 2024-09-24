package com.yoanan.RPSGame.dto;

import com.yoanan.RPSGame.model.Player;

public class ResultGameDto {

    private Player winner;

    private int userScore;

    private int computerScore;

    private int drawScore;

    public ResultGameDto() {
    }

    public ResultGameDto(Player winner, int userScore, int computerScore, int drawScore) {
        this.winner = winner;
        this.userScore = userScore;
        this.computerScore = computerScore;
        this.drawScore = drawScore;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public int getDrawScore() {
        return drawScore;
    }

    public void setDrawScore(int drawScore) {
        this.drawScore = drawScore;
    }


}
