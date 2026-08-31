package com.gamechanger.inventory.dto.console;

import com.gamechanger.inventory.dto.game_console.ConsoleGameDTO;
import com.gamechanger.inventory.dto.game_console.GameConsoleDTO;
import com.gamechanger.inventory.dto.platform.SimplePlatformDTO;
import com.gamechanger.inventory.model.Console;
import com.gamechanger.inventory.model.GameConsole;
import lombok.Data;

import java.util.List;

@Data
public class ConsoleDTO {

    private Long id;
    private String name;
    private String alias;

    private SimplePlatformDTO platform;
    private List<ConsoleGameDTO> games;

    public ConsoleDTO() {}
    public ConsoleDTO(Console console) {
        this.id = console.getId();
        this.name = console.getName();
        this.alias = console.getAlias();

        this.platform = new SimplePlatformDTO(console.getPlatform());
        this.games = console.getGames().stream().map(ConsoleGameDTO::new).toList();
    }

}
