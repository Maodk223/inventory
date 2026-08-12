package com.gamechanger.inventory.dto.platform;

import com.gamechanger.inventory.dto.console.SimpleConsoleDTO;
import com.gamechanger.inventory.model.Platform;
import lombok.Data;

import java.util.List;

@Data
public class PlatformDTO {

    private Long id;
    private String name;

    private List<SimpleConsoleDTO> consoles;

    public  PlatformDTO() {}
    public PlatformDTO(Platform platform) {
        this.id = platform.getId();
        this.name = platform.getName();

        this.consoles = platform.getConsoles().stream().map(SimpleConsoleDTO::new).toList();
    }

}
