package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.model.Studio;
import com.gamechanger.inventory.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/studios")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping
    public Iterable<Studio> getStudios() { return studioService.getStudios(); }

    @GetMapping("/{id}")
    public Studio getStudio(@PathVariable final long id) {
        return studioService.getStudio(id).orElse(null);
    }

    @PostMapping
    public Studio createStudio(@RequestBody Studio studio) { return studioService.saveStudio(studio); }

    @DeleteMapping("/{id}")
    public void deleteStudio(@PathVariable final long id) {
        studioService.deleteStudio(id);
    }

    @PutMapping("/{id}")
    public Studio updateStudio(@PathVariable final long id, @RequestBody Studio studio) {
        Optional<Studio> optionalStudio = studioService.getStudio(id);
        if(optionalStudio.isEmpty()) return null;
        Studio currentStudio = optionalStudio.get();

        String name = studio.getName();
        if(name != null) currentStudio.setName(name);

        return studioService.saveStudio(currentStudio);
    }

}
