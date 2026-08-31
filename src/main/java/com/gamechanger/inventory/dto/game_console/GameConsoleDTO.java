package com.gamechanger.inventory.dto.game_console;

import com.gamechanger.inventory.model.Console;
import com.gamechanger.inventory.model.Game;
import com.gamechanger.inventory.model.GameConsole;
import lombok.Data;

@Data
public class GameConsoleDTO {

    private Long Id;
    private String name;
    private String alias;
    private byte[] jacket;

    public GameConsoleDTO(GameConsole gameConsole) {
        Console console = gameConsole.getConsole();
        this.Id = console.getId();
        this.name = console.getName();
        this.alias = console.getAlias();

        this.jacket = gameConsole.getJacket();
    }
}
