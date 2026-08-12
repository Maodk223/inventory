package com.gamechanger.inventory.dto.studio;

import com.gamechanger.inventory.model.Studio;
import lombok.Data;

@Data
public class SimpleStudioDTO {

    private Long id;
    private String name;

    public  SimpleStudioDTO() {}
    public SimpleStudioDTO(Studio studio) {
        this.id = studio.getId();
        this.name = studio.getName();
    }

}
