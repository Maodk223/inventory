package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.model.Game;
import com.gamechanger.inventory.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/games")
class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public Iterable<Game> getGames() { return gameService.getGames(); }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable final long id) {
        return gameService.getGame(id).orElse(null);
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) { return gameService.saveGame(game); }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable final long id) {
        gameService.deleteGame(id);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable final long id, @RequestBody Game game) {
        Optional<Game> optionalGame = gameService.getGame(id);
        if(optionalGame.isEmpty()) return null;
        Game currentGame = optionalGame.get();

        String name = game.getName();
        if(name != null) currentGame.setName(name);

        Date date = game.getReleaseDate();
        if(date != null) game.setReleaseDate(date);

        return gameService.saveGame(currentGame);
    }

}
