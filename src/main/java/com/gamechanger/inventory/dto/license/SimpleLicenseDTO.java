package com.gamechanger.inventory.dto.license;

import com.gamechanger.inventory.model.License;
import lombok.Data;

@Data
public class SimpleLicenseDTO {

    private Long id;
    private String name;

    public SimpleLicenseDTO() {}
    public SimpleLicenseDTO(License license) {
        this.id = license.getId();
        this.name = license.getName();
    }

}
