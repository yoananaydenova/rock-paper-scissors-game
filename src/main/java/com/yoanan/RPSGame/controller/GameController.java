package com.yoanan.RPSGame.controller;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.dto.MoveDto;
import com.yoanan.RPSGame.dto.ResultGameDto;
import com.yoanan.RPSGame.service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping("/")
    public String home() {
        return "Hey! You can play RSP here!";
    }

    @PostMapping("/start")
    public ResponseEntity<GameDto> createGame(@Valid @RequestBody GameDto gameDto) {
        final GameDto savedGame = gameService.createGame(gameDto.getAttempts());
        return ResponseEntity.ok(savedGame);
    }

    @PostMapping("/game")
    public ResponseEntity<ResultGameDto> playGame(@Valid @RequestBody MoveDto moveDto) {
        final ResultGameDto resultGame = gameService.playGame(moveDto);
        return ResponseEntity.ok(resultGame);
    }


    @GetMapping("/game/{gameId}")
    public ResponseEntity<ResultGameDto> getGame(@PathVariable Long gameId) {
        final ResultGameDto resultGame = gameService.findGame(gameId);
        return ResponseEntity.ok(resultGame);
    }

    @PostMapping("/stop/{gameId}")
    public ResponseEntity<ResultGameDto> stopGame(@PathVariable Long gameId) {
        final ResultGameDto resultGame = gameService.stopGame(gameId);
        return ResponseEntity.ok(resultGame);
    }

}
