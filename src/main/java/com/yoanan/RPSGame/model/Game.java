package com.yoanan.RPSGame.model;
import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name="attempts", nullable = false)
    private int attempts;

    @Column(name="userScore")
    private int userScore;

    @Column(name="computerScore")
    private int computerScore;

    @Column(name="drawScore")
    private int drawScore;

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


    public void increaseUserScore(){
        this.userScore = this.userScore+1;
    }

    public void increaseComputerScore(){
        this.computerScore = this.computerScore+1;
    }

    public void increaseDrawScore(){
        this.drawScore = this.drawScore+1;
    }
}
