package com.yoanan.RPSGame.mapper;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.model.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDto toItemDto(Game game);
}
