package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.game.CreateGameDTO;
import com.gamechanger.inventory.dto.game.GameDTO;
import com.gamechanger.inventory.model.Game;
import com.gamechanger.inventory.model.License;
import com.gamechanger.inventory.model.Studio;
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

    private final EntityManager entityManager;

    public GameService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<GameDTO> getGame(final long id) {
        return gameRepository.findById(id).map(GameDTO::new);
    }

    public Iterable<GameDTO> getGames() {
        ArrayList<GameDTO> games = new ArrayList<>();
        gameRepository.findAll().forEach(game -> games.add(new GameDTO(game)));
        return games;
    }

    public void deleteGame(final long id) { gameRepository.deleteById(id); }

    public GameDTO saveGame(CreateGameDTO dto) {
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
}
