package com.yoanan.RPSGame.service;

import com.yoanan.RPSGame.model.GameMove;
import com.yoanan.RPSGame.model.Player;

public interface MoveService {

    void setUserMove(GameMove playerMove);

    void setComputerMove(GameMove computerMove);

    Player calculateMoveWinner(String userMoveStr);

}
