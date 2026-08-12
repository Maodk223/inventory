package com.gamechanger.inventory.dto.platform;

import com.gamechanger.inventory.model.Platform;
import lombok.Data;

@Data
public class SimplePlatformDTO {

    private Long id;
    private String name;

    public SimplePlatformDTO() {}
    public SimplePlatformDTO(Platform platform) {
        this.id = platform.getId();
        this.name = platform.getName();
    }

}
