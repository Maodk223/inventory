package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.Platform;
import com.gamechanger.inventory.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    public Optional<Platform> getPlatform(final long id) { return platformRepository.findById(id); }

    public Iterable<Platform> getPlatforms() { return platformRepository.findAll(); }

    public void deletePlatform(final long id) { platformRepository.deleteById(id); }

    public Platform savePlatform(Platform platform) { return platformRepository.save(platform); }
}
