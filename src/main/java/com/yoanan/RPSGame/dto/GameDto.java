package com.yoanan.RPSGame.dto;

import jakarta.validation.constraints.Min;

public class GameDto {

    private Long id;

    @Min(value = 1, message = "The attempts value must be greater than or equal to 1!")
    private int attempts;

    public GameDto() {
    }

    public GameDto(int attempts) {
        this.attempts = attempts;
    }

    public GameDto(Long id, int attempts) {
        this.id = id;
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
}
