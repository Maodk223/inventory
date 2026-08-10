package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.model.Platform;
import com.gamechanger.inventory.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/platforms")
class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping
    public Iterable<Platform> getPlatforms() { return platformService.getPlatforms(); }

    @GetMapping("/{id}")
    public Platform getPlatform(@PathVariable final long id) {
        return platformService.getPlatform(id).orElse(null);
    }

    @PostMapping
    public Platform createPlatform(@RequestBody Platform platform) { return platformService.savePlatform(platform); }

    @DeleteMapping("/{id}")
    public void deletePlatform(@PathVariable final long id) {
        platformService.deletePlatform(id);
    }

    @PutMapping("/{id}")
    public Platform updatePlatform(@PathVariable final long id, @RequestBody Platform platform) {
        Optional<Platform> optionalPlatform = platformService.getPlatform(id);
        if(optionalPlatform.isEmpty()) return null;
        Platform currentPlatform = optionalPlatform.get();

        String name = platform.getName();
        if(name != null) currentPlatform.setName(name);

        return platformService.savePlatform(currentPlatform);
    }

}
