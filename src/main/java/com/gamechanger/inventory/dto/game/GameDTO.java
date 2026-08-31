package com.gamechanger.inventory.dto.game;

import com.gamechanger.inventory.dto.game_console.GameConsoleDTO;
import com.gamechanger.inventory.dto.genre.SimpleGenreDTO;
import com.gamechanger.inventory.dto.license.SimpleLicenseDTO;
import com.gamechanger.inventory.dto.mode.SimpleModeDTO;
import com.gamechanger.inventory.dto.studio.SimpleStudioDTO;
import com.gamechanger.inventory.model.Game;
import com.gamechanger.inventory.model.License;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GameDTO {

    private Long id;
    private String name;
    private Date releaseDate;
    private byte[] image;

    private SimpleLicenseDTO license;
    private SimpleStudioDTO studio;

    private List<SimpleGenreDTO> genres;
    private List<SimpleModeDTO> modes;
    private List<GameConsoleDTO>  consoles;

    public GameDTO(Game game) {
        this.id = game.getId();
        this.name = game.getName();
        this.releaseDate = game.getReleaseDate();
        this.image = game.getImage();

        this.studio = new SimpleStudioDTO(game.getStudio());

        License license  = game.getLicense();
        if(license != null)
            this.license = new SimpleLicenseDTO(game.getLicense());
        else this.license = null;

        this.modes = game.getModes().stream().map(SimpleModeDTO::new).toList();
        this.genres = game.getGenres().stream().map(SimpleGenreDTO::new).toList();
        this.consoles = game.getConsoles().stream().map(GameConsoleDTO::new).toList();
    }

}
