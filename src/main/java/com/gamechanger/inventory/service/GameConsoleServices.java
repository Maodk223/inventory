package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.GameConsole;
import com.gamechanger.inventory.model.GameConsoleKey;
import com.gamechanger.inventory.repository.GameConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameConsoleServices {

    @Autowired
    GameConsoleRepository gameConsoleRepository;

    public Optional<GameConsole> getGameConsole(GameConsoleKey id) { return gameConsoleRepository.findById(id); }

    public Iterable<GameConsole> getGameConsoles() { return gameConsoleRepository.findAll(); }

    public void deleteGameConsole(GameConsoleKey id) { gameConsoleRepository.deleteById(id); }

    public GameConsole saveGameConsole(GameConsole gameConsole) { return gameConsoleRepository.save(gameConsole); }
}
