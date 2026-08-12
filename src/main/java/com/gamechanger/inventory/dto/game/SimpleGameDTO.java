package com.gamechanger.inventory.dto.game;

import com.gamechanger.inventory.model.Game;
import lombok.Data;

import java.util.Date;

@Data
public class SimpleGameDTO {

    private Long id;
    private String name;
    private Date releaseDate;
    private byte[] image;

    public SimpleGameDTO() {}
    public SimpleGameDTO(final Game game) {
        this.id = game.getId();
        this.name = game.getName();
        this.releaseDate = game.getReleaseDate();
        this.image = game.getImage();
    }

}
