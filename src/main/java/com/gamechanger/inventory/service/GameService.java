package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.console.CreateConsoleDTO;
import com.gamechanger.inventory.dto.game.CreateGameDTO;
import com.gamechanger.inventory.dto.game.GameDTO;
import com.gamechanger.inventory.dto.game_console.CreateGameConsoleDTO;
import com.gamechanger.inventory.model.*;
import com.gamechanger.inventory.repository.GameConsoleRepository;
import com.gamechanger.inventory.repository.GameRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameConsoleRepository gameConsoleRepository;

    private final EntityManager entityManager;

    public GameService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<GameDTO> getGame(final long id) {
        return gameRepository.findById(id).map(GameDTO::new);
    }

    public Optional<GameDTO> getGame(final String name) {
        return gameRepository.findByName(name).map(GameDTO::new);
    }

    public Iterable<GameDTO> getGames() {
        ArrayList<GameDTO> games = new ArrayList<>();
        gameRepository.findAll().forEach(game -> games.add(new GameDTO(game)));
        return games;
    }

    public void deleteGame(final long id) { gameRepository.deleteById(id); }

    public GameDTO saveGame(CreateGameDTO dto) {
        Optional<Game> exist = gameRepository.findByName(dto.getName());
        if (exist.isPresent())
            return new GameDTO(exist.get());

        Game game = new Game();

        game.setName(dto.getName());
        game.setReleaseDate(dto.getReleaseDate());
        game.setImage(dto.getImage());

        game.setStudio(entityManager.getReference(Studio.class, dto.getStudioId()));

        Long licenseId = dto.getLicenseId();
        if (licenseId != null)
            game.setLicense(entityManager.getReference(License.class, licenseId));

        return new GameDTO(gameRepository.save(game));
    }

    public  GameDTO updateGame(Long gameId, CreateGameDTO dto) {
        Game game = gameRepository.findById(gameId).orElseThrow();

        game.setName(dto.getName());
        game.setReleaseDate(dto.getReleaseDate());
        game.setImage(dto.getImage());

        game.setStudio(entityManager.getReference(Studio.class, dto.getStudioId()));
        game.setLicense(entityManager.getReference(License.class, dto.getLicenseId()));

        return new GameDTO(gameRepository.save(game));
    }

    public GameDTO linkGenre(Long gameId, Long genreId) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        Genre genre = entityManager.getReference(Genre.class, genreId);
        if(!game.getGenres().contains(genre))
            game.addGenre(genre);
        return new GameDTO(gameRepository.save(game));
    }

    public GameDTO unlinkGenre(Long gameId, Long genreId) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        Genre genre = entityManager.getReference(Genre.class, genreId);
        game.removeGenre(genre);
        return new GameDTO(gameRepository.save(game));
    }

    public GameDTO linkMode(Long gameId, Long modeId) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        Mode mode = entityManager.getReference(Mode.class, modeId);
        if(!game.getModes().contains(mode))
            game.addMode(mode);
        return new GameDTO(gameRepository.save(game));
    }

    public GameDTO unlinkMode(Long gameId, Long modeId) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        Mode mode = entityManager.getReference(Mode.class, modeId);
        game.removeMode(mode);
        return new GameDTO(gameRepository.save(game));
    }

    public GameDTO linkConsole(Long gameId, Long consoleId, CreateGameConsoleDTO dto) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        Console console = entityManager.getReference(Console.class, consoleId);
        GameConsoleKey key = new GameConsoleKey();
        key.setGameId(gameId);
        key.setConsoleId(consoleId);


        GameConsole gameConsole = entityManager.find(GameConsole.class, key);
        if(gameConsole == null) {
            gameConsole = new GameConsole();
            gameConsole.setGame(game);
            gameConsole.setConsole(console);
        }
        gameConsole.setJacket(dto.getJacket());
        gameConsoleRepository.save(gameConsole);

        return new GameDTO(game);
    }

    public GameDTO unlinkConsole(Long gameId, Long consoleId) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        GameConsoleKey key = new GameConsoleKey();
        key.setGameId(gameId);
        key.setConsoleId(consoleId);

        GameConsole gameConsole = entityManager.getReference(GameConsole.class, key);
        gameConsoleRepository.delete(gameConsole);

        return new GameDTO(game);
    }
}
