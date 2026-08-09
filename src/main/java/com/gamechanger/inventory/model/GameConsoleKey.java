package com.gamechanger.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class GameConsoleKey implements Serializable {
        @Column(name = "jeu_id")
        Long gameId;

        @Column(name = "console_id")
        Long consoleId;
}
