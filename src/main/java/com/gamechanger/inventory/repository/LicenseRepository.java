package com.gamechanger.inventory.repository;

import com.gamechanger.inventory.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
}
