package com.gamechanger.inventory.dto.genre;

import com.gamechanger.inventory.model.Genre;
import lombok.Data;

@Data
public class SimpleGenreDTO {

    private Long id;
    private String name;

    public SimpleGenreDTO() {}
    public SimpleGenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
    }

}
