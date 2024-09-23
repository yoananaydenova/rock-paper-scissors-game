package com.yoanan.RPSGame.dto;

public class GameDto {
   private String id;
   private int attempts;

    public GameDto() {
    }

    public GameDto(String id, int attempts) {
        this.id = id;
        this.attempts = attempts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}
