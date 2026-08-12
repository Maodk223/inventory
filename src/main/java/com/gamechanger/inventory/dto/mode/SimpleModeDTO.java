package com.gamechanger.inventory.dto.mode;

import com.gamechanger.inventory.model.Mode;
import lombok.Data;

@Data
public class SimpleModeDTO {

    private Long id;
    private String name;

    public SimpleModeDTO() {}
    public SimpleModeDTO(Mode mode) {
        this.id = mode.getId();
        this.name = mode.getName();
    }

}
