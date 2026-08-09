package com.gamechanger.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name = "jeu_console")
public class GameConsole {
    @EmbeddedId
    GameConsoleKey id;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "jeu_id")
    Game game;

    @ManyToOne
    @MapsId("consoleId")
    @JoinColumn(name = "console_id")
    Console console;

    @Column(name = "jaquette")
    private byte[] jacket;

}
