package com.gamechanger.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "console")
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String name;

    @Column
    private String alias;

    @ManyToOne
    @JoinColumn(name = "plateforme_id", nullable = false)
    private Platform platform;

    @OneToMany(mappedBy = "console")
    private List<GameConsole> games = new ArrayList<>();
}
