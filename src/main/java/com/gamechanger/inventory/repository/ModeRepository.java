package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.Mode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeRepository  extends CrudRepository<Mode, Long> {
    Optional<Mode> findByName(String name);
}
