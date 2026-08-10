package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.Game;
import com.gamechanger.inventory.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Optional<Game> getGame(final long id) { return gameRepository.findById(id); }

    public Iterable<Game> getGames() { return gameRepository.findAll(); }

    public void deleteGame(final long id) { gameRepository.deleteById(id); }

    public Game saveGame(Game game) { return gameRepository.save(game); }
}
