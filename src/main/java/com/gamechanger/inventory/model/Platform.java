package com.gamechanger.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "plateforme")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String name;

    @OneToMany(mappedBy = "platform")
    private List<Console> consoles = new ArrayList<>();
}
