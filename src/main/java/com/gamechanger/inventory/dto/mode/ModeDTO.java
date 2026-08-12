package com.gamechanger.inventory.dto.mode;

import com.gamechanger.inventory.dto.game.SimpleGameDTO;
import com.gamechanger.inventory.model.Mode;
import lombok.Data;

import java.util.List;

@Data
public class ModeDTO {

    private Long id;
    private String name;

    private List<SimpleGameDTO> games;

    public ModeDTO() {}
    public ModeDTO(Mode mode) {
        this.id = mode.getId();
        this.name = mode.getName();

        this.games = mode.getGames().stream().map(SimpleGameDTO::new).toList();
    }

}
