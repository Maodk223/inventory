package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.Genre;
import com.gamechanger.inventory.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Optional<Genre> getGenre(final long id) { return genreRepository.findById(id); }

    public Iterable<Genre> getGenres() { return genreRepository.findAll(); }

    public void deleteGenre(final long id) { genreRepository.deleteById(id); }

    public Genre saveGenre(Genre genre) { return genreRepository.save(genre); }
}
