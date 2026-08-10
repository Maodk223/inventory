package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.Mode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepository  extends CrudRepository<Mode, Long> {
}
