package com.yoanan.RPSGame.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.dto.MoveDto;
import com.yoanan.RPSGame.dto.ResultGameDto;
import com.yoanan.RPSGame.model.Player;
import com.yoanan.RPSGame.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Test
    public void testCreateGameIntegration() throws Exception {

        GameDto savedGame = new GameDto(5);

        given(gameService.createGame(any(Integer.class))).willReturn(savedGame);

        mockMvc.perform(post("/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "attempts": 5
                                }"""))
                .andExpect(status().isOk());
    }

    @Test
    public void testPlayGameIntegration() throws Exception {

        ResultGameDto resultGameDto = new ResultGameDto()
                .setGameWinner(Player.DRAW)
                .setFinished(false)
                .setAttempts(5)
                .setCurrentAttempt(1)
                .setUserScore(0)
                .setComputerScore(0)
                .setDrawScore(1);

        given(gameService.playGame(any(MoveDto.class))).willReturn(resultGameDto);

        mockMvc.perform(put("/game")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "id":1,
                                    "move":"scissors"
                                }"""))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetGameIntegration() throws Exception {

        ResultGameDto resultGameDto = new ResultGameDto()
                .setGameWinner(Player.DRAW)
                .setFinished(false)
                .setAttempts(5)
                .setCurrentAttempt(1)
                .setUserScore(0)
                .setComputerScore(0)
                .setDrawScore(1);

        given(gameService.findGame(any(Long.class))).willReturn(resultGameDto);

        mockMvc.perform(get("/game/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isOk());
    }

    @Test
    public void testStopGameIntegration() throws Exception {

        ResultGameDto resultGameDto = new ResultGameDto()
                .setGameWinner(Player.DRAW)
                .setFinished(false)
                .setAttempts(5)
                .setCurrentAttempt(0)
                .setUserScore(0)
                .setComputerScore(0)
                .setDrawScore(1);

        given(gameService.stopGame(any(Long.class))).willReturn(resultGameDto);

        mockMvc.perform(put("/stop/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isOk());
    }
}
