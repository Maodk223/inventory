package com.gamechanger.inventory.dto.genre;

import com.gamechanger.inventory.dto.game.SimpleGameDTO;
import com.gamechanger.inventory.model.Genre;
import lombok.Data;

import java.util.List;

@Data
public class GenreDTO {

    private Long id;
    private String name;

    private List<SimpleGameDTO>  games;

    public GenreDTO() {}
    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();

        this.games = genre.getGames().stream().map(SimpleGameDTO::new).toList();
    }

}
