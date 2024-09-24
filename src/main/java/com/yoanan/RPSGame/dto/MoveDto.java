package com.yoanan.RPSGame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MoveDto {
    @JsonProperty("id")
    @NotNull(message = "The game id is required!")
    private Long gameId;

    @NotNull(message = "The move is required!")
    @NotBlank(message = "The move is required!")
    private String move;

    public MoveDto() {
    }

    public MoveDto(Long gameId, String move) {
        this.gameId = gameId;
        this.move = move;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
