package com.yoanan.RPSGame.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "attempts", nullable = false)
    @ColumnDefault("1")
    private int attempts;

    @Column(name = "currentAttempt", nullable = false)
    @ColumnDefault("0")
    private int currentAttempt;

    @Column(name = "userScore")
    @ColumnDefault("0")
    private int userScore;

    @Column(name = "computerScore")
    @ColumnDefault("0")
    private int computerScore;

    @Column(name = "drawScore")
    @ColumnDefault("0")
    private int drawScore;

    @Column(name = "isFinished")
    private boolean isFinished = false;

    public Game() {
    }

    public Game(Integer attempts) {
        this.attempts = attempts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
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

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void setCurrentAttempt(int currentAttempt) {
        this.currentAttempt = currentAttempt;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Game setFinished(boolean finished) {
        isFinished = finished;
        return this;
    }

    public void increaseUserScore() {
        this.userScore++;
    }

    public void increaseComputerScore() {
        this.computerScore++;
    }

    public void increaseDrawScore() {
        this.drawScore++;
    }

    public void increaseCurrentAttempt() {
        this.currentAttempt++;
    }

}
