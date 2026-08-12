package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.genre.CreateGenreDTO;
import com.gamechanger.inventory.dto.genre.GenreDTO;
import com.gamechanger.inventory.model.Genre;
import com.gamechanger.inventory.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Optional<GenreDTO> getGenre(final long id) {
        return genreRepository.findById(id).map(GenreDTO::new);
    }

    public Iterable<GenreDTO> getGenres() {
        ArrayList<GenreDTO> genres = new ArrayList<>();
        genreRepository.findAll().forEach(g -> genres.add(new GenreDTO(g)));
        return genres;
    }

    public void deleteGenre(final long id) { genreRepository.deleteById(id); }

    public GenreDTO saveGenre(CreateGenreDTO dto) {
        Genre genre = new Genre();
        genre.setName(dto.getName());
        return new GenreDTO(genreRepository.save(genre));
    }

    public GenreDTO updateGenre(final long id, final CreateGenreDTO dto) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genre.setName(dto.getName());
        return new GenreDTO(genreRepository.save(genre));
    }
}
