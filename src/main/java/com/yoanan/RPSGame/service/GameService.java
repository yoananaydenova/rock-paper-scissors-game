package com.yoanan.RPSGame.service;

import com.yoanan.RPSGame.dto.GameDto;

public interface GameService {
    GameDto createGame(Integer attempts);
}
