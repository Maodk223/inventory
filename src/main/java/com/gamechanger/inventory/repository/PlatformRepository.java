package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.Platform;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatformRepository  extends CrudRepository<Platform, Long> {
    Optional<Platform> findByName(String name);
}
