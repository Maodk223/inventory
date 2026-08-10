package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.model.Genre;
import com.gamechanger.inventory.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/genres")
class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public Iterable<Genre> getGenres() { return genreService.getGenres(); }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable final long id) {
        return genreService.getGenre(id).orElse(null);
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) { return genreService.saveGenre(genre); }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable final long id) {
        genreService.deleteGenre(id);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable final long id, @RequestBody Genre genre) {
        Optional<Genre> optionalGenre = genreService.getGenre(id);
        if(optionalGenre.isEmpty()) return null;
        Genre currentGenre = optionalGenre.get();

        String name = genre.getName();
        if(name != null) currentGenre.setName(name);

        return genreService.saveGenre(currentGenre);
    }

}
