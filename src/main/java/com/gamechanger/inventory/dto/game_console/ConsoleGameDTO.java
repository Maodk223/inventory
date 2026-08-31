package com.gamechanger.inventory.dto.game_console;

import com.gamechanger.inventory.model.Game;
import com.gamechanger.inventory.model.GameConsole;
import lombok.Data;

import java.util.Date;

@Data
public class ConsoleGameDTO {

    private Long id;
    private String name;
    private Date releaseDate;

    private byte[] jacket;

    public ConsoleGameDTO(GameConsole gameConsole) {
        Game game = gameConsole.getGame();
        this.id = game.getId();
        this.name = game.getName();
        this.releaseDate = game.getReleaseDate();

        this.jacket = gameConsole.getJacket();
    }
}
