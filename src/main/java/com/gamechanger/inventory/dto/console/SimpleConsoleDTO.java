package com.gamechanger.inventory.dto.console;

import com.gamechanger.inventory.model.Console;
import lombok.Data;

@Data
public class SimpleConsoleDTO {

    private Long id;
    private String name;
    private String alias;

    public SimpleConsoleDTO() {}
    public SimpleConsoleDTO(final Console console) {
        this.id = console.getId();
        this.name = console.getName();
        this.alias = console.getAlias();
    }

}
