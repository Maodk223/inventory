package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.platform.CreatePlatformDTO;
import com.gamechanger.inventory.dto.platform.PlatformDTO;
import com.gamechanger.inventory.service.PlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Platforms")
@RequestMapping("/platforms")
class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping
    public Iterable<PlatformDTO> getPlatforms() { return platformService.getPlatforms(); }

    @GetMapping("/{id}")
    public PlatformDTO getPlatform(@PathVariable final long id) {
        return platformService.getPlatform(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public PlatformDTO getPlatform(@PathVariable final String name) {
        return platformService.getPlatform(name).orElse(null);
    }

    @PostMapping
    public PlatformDTO createPlatform(@RequestBody CreatePlatformDTO platform) { return platformService.savePlatform(platform); }

    @DeleteMapping("/{id}")
    public void deletePlatform(@PathVariable final long id) {
        platformService.deletePlatform(id);
    }

    @PutMapping("/{id}")
    public PlatformDTO updatePlatform(@PathVariable final long id, @RequestBody CreatePlatformDTO platform) {
        return platformService.updatePlatform(id, platform);
    }

}
