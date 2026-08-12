package com.gamechanger.inventory.dto.game;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.util.Date;

@Data
public class CreateGameDTO {

    private String name;
    private Date releaseDate;
    private byte[] image;

    private Long licenseId;
    private Long studioId;
}
