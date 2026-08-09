package com.gamechanger.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "jeu")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String name;

    @Column(name = "date_sortie")
    private Date releaseDate;

    @Column
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "licence_id")
    private License license;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @ManyToMany
    @JoinTable(
            name = "jeu_genre",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "jeu_mode",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "mode_id")
    )
    private List<Mode> modes = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<GameConsole> consoles = new ArrayList<>();

    public void addGenre(Genre genre) {
        genres.add(genre);
        genre.getGames().add(this);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
        genre.getGames().remove(this);
    }

    public void addMode(Mode mode) {
        modes.add(mode);
        mode.getGames().add(this);
    }

    public void removeMode(Mode mode) {
        modes.remove(mode);
        mode.getGames().remove(this);
    }

}
