package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.genre.CreateGenreDTO;
import com.gamechanger.inventory.dto.genre.GenreDTO;
import com.gamechanger.inventory.service.GenreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Genres")
@RequestMapping("/genres")
class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public Iterable<GenreDTO> getGenres() { return genreService.getGenres(); }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable final long id) {
        return genreService.getGenre(id).orElse(null);
    }

    @PostMapping
    public GenreDTO createGenre(@RequestBody CreateGenreDTO genre) { return genreService.saveGenre(genre); }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable final long id) {
        genreService.deleteGenre(id);
    }

    @PutMapping("/{id}")
    public GenreDTO updateGenre(@PathVariable final long id, @RequestBody CreateGenreDTO genre) {
        return genreService.updateGenre(id, genre);
    }

}
