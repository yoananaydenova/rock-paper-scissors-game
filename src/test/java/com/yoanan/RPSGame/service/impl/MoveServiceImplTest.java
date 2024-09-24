package com.yoanan.RPSGame.service.impl;

import com.yoanan.RPSGame.exception.NoSuchMoveException;
import com.yoanan.RPSGame.model.*;
import com.yoanan.RPSGame.service.MoveService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class MoveServiceImplTest {

    @Mock
    private MoveService moveService;


    @Test
    void testGetMoveWithValidMoveCode() {
        GameMove rockMove = RockMove.getInstance();
        GameMove retrievedMove = MoveServiceImpl.getMove("1");
        assertEquals(rockMove, retrievedMove);
    }

    @Test
    void testGetMoveWithValidMoveName() {
        GameMove scissorsMove = ScissorsMove.getInstance();
        GameMove retrievedMove = MoveServiceImpl.getMove("scissors");
        assertEquals(scissorsMove, retrievedMove);
    }

    @Test
    void testGetMoveWithInvalidMoveCode() {
        assertThrows(NoSuchMoveException.class, () -> MoveServiceImpl.getMove("4"));
    }

    @Test
    void testGetMoveWithInvalidMoveName() {
        assertThrows(NoSuchMoveException.class, () -> MoveServiceImpl.getMove("invalid"));
    }
}

