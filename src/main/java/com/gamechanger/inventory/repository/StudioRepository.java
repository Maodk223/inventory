package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository  extends CrudRepository<Studio, Long> {
}
