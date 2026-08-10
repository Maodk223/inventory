package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.GameConsole;
import com.gamechanger.inventory.model.GameConsoleKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameConsoleRepository extends CrudRepository<GameConsole, GameConsoleKey> {
}
