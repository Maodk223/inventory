package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.game.CreateGameDTO;
import com.gamechanger.inventory.dto.game.GameDTO;
import com.gamechanger.inventory.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Games")
@RequestMapping("/games")
class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public Iterable<GameDTO> getGames() { return gameService.getGames(); }

    @GetMapping("/{id}")
    public GameDTO getGame(@PathVariable final long id) {
        return gameService.getGame(id).orElse(null);
    }

    @PostMapping
    public GameDTO createGame(@RequestBody CreateGameDTO game) { return gameService.saveGame(game); }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable final long id) {
        gameService.deleteGame(id);
    }

    @PutMapping("/{id}")
    public GameDTO updateGame(@PathVariable final long id, @RequestBody CreateGameDTO game) {
        return gameService.updateGame(id, game);
    }

}
