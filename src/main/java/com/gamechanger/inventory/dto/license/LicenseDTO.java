package com.gamechanger.inventory.dto.license;

import com.gamechanger.inventory.dto.game.SimpleGameDTO;
import com.gamechanger.inventory.model.License;
import lombok.Data;

import java.util.List;

@Data
public class LicenseDTO {

    private Long id;
    private String name;

    private List<SimpleGameDTO> games;

    public LicenseDTO() {}
    public LicenseDTO(License license) {
        this.id = license.getId();
        this.name = license.getName();

        this.games = license.getGames().stream().map(SimpleGameDTO::new).toList();
    }

}
