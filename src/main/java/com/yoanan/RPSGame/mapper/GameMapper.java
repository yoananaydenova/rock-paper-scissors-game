package com.yoanan.RPSGame.mapper;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface GameMapper {
    GameDto toItemDto(Game game);
}
