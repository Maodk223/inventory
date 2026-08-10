package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.Console;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends CrudRepository<Console, Long> {
}
