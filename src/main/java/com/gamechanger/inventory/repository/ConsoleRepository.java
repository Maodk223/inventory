package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.Console;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsoleRepository extends CrudRepository<Console, Long> {
    Optional<Console> findByName(String name);
    Optional<Console> findByAlias(String alias);
}
