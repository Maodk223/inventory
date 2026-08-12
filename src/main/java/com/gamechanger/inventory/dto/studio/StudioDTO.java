package com.gamechanger.inventory.dto.studio;

import com.gamechanger.inventory.dto.game.SimpleGameDTO;
import com.gamechanger.inventory.model.Studio;
import lombok.Data;

import java.util.List;

@Data
public class StudioDTO {

    private Long id;
    private String name;

    private List<SimpleGameDTO> productions;

    public StudioDTO() {}
    public StudioDTO(Studio studio) {
        this.id = studio.getId();
        this.name = studio.getName();

        this.productions = studio.getProductions().stream().map(SimpleGameDTO::new).toList();
    }

}
