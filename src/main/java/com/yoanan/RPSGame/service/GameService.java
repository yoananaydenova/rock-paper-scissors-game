package com.yoanan.RPSGame.service;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.dto.MoveDto;
import com.yoanan.RPSGame.dto.ResultGameDto;

public interface GameService {
    GameDto createGame(Integer attempts);

    ResultGameDto playGame(MoveDto moveDto);

    ResultGameDto stopGame(Long id);
}
