package com.gamechanger.inventory.dto.console;

import lombok.Data;

@Data
public class CreateConsoleDTO {

    private String name;
    private String alias = "";

    private Long platformId;

}
