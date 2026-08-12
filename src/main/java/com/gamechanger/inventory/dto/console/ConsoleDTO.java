package com.gamechanger.inventory.dto.console;

import com.gamechanger.inventory.dto.platform.SimplePlatformDTO;
import com.gamechanger.inventory.model.Console;
import lombok.Data;

@Data
public class ConsoleDTO {

    private Long id;
    private String name;
    private String alias;

    private SimplePlatformDTO platform;

    public ConsoleDTO() {}
    public ConsoleDTO(Console console) {
        this.id = console.getId();
        this.name = console.getName();
        this.alias = console.getAlias();

        this.platform = new SimplePlatformDTO(console.getPlatform());
    }

}
