package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.platform.CreatePlatformDTO;
import com.gamechanger.inventory.dto.platform.PlatformDTO;
import com.gamechanger.inventory.model.Platform;
import com.gamechanger.inventory.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    public Optional<PlatformDTO> getPlatform(final long id) { return platformRepository.findById(id).map(PlatformDTO::new); }

    public Iterable<PlatformDTO> getPlatforms() {
        ArrayList<PlatformDTO> platforms = new ArrayList<>();
        platformRepository.findAll().forEach(platform -> platforms.add(new PlatformDTO(platform)));
        return platforms;
    }

    public void deletePlatform(final long id) { platformRepository.deleteById(id); }

    public PlatformDTO savePlatform(CreatePlatformDTO dto) {
        Platform platform = new Platform();
        platform.setName(dto.getName());
        return new PlatformDTO(platformRepository.save(platform));
    }

    public PlatformDTO updatePlatform(final long id, CreatePlatformDTO dto) {
        Platform platform = platformRepository.findById(id).orElseThrow();
        platform.setName(dto.getName());
        return new PlatformDTO(platformRepository.save(platform));
    }
}
