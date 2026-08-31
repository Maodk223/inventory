package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.console.CreateConsoleDTO;
import com.gamechanger.inventory.dto.game.CreateGameDTO;
import com.gamechanger.inventory.dto.game.GameDTO;
import com.gamechanger.inventory.dto.game_console.CreateGameConsoleDTO;
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

    @GetMapping("/name/{name}")
    public GameDTO getGame(@PathVariable final String name) {
        return gameService.getGame(name).orElse(null);
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

    @PostMapping("/link/game_id/{gameId}/genre_id/{genreId}")
    public GameDTO linkGenre(@PathVariable final long gameId, @PathVariable final long genreId) {
        return gameService.linkGenre(gameId, genreId);
    }

    @DeleteMapping("/unlink/game_id/{gameId}/genre_id/{genreId}")
    public GameDTO unlinkGenre(@PathVariable final long gameId, @PathVariable final long genreId) {
        return gameService.unlinkGenre(gameId, genreId);
    }

    @PostMapping("link/game_id/{gameId}/mode_id/{modeId}")
    public GameDTO linkMode(@PathVariable final long gameId, @PathVariable final long modeId) {
        return gameService.linkMode(gameId, modeId);
    }

    @DeleteMapping("unlink/game_id/{gameId}/mode_id/{modeId}")
    public GameDTO unlinkMode(@PathVariable final long gameId, @PathVariable final long modeId) {
        return gameService.unlinkMode(gameId, modeId);
    }

    @PostMapping("/link/game_id/{gameId}/console_id/{consoleId}")
    public GameDTO linkConsole(@PathVariable final long gameId, @PathVariable final long consoleId, @RequestBody CreateGameConsoleDTO gameConsole) {
        return gameService.linkConsole(gameId, consoleId, gameConsole);
    }

    @DeleteMapping("/unlink/game_id/{gameId}/console_id/{consoleId}")
    public GameDTO unlinkConsole(@PathVariable final long gameId, @PathVariable final long consoleId) {
        return gameService.unlinkConsole(gameId, consoleId);
    }

}
