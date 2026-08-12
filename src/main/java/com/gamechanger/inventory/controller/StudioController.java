package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.studio.CreateStudioDTO;
import com.gamechanger.inventory.dto.studio.StudioDTO;
import com.gamechanger.inventory.service.StudioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Studios")
@RequestMapping("/studios")
class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping
    public Iterable<StudioDTO> getStudios() { return studioService.getStudios(); }

    @GetMapping("/{id}")
    public StudioDTO getStudio(@PathVariable final long id) {
        return studioService.getStudio(id).orElse(null);
    }

    @PostMapping
    public StudioDTO createStudio(@RequestBody CreateStudioDTO studio) { return studioService.saveStudio(studio); }

    @DeleteMapping("/{id}")
    public void deleteStudio(@PathVariable final long id) {
        studioService.deleteStudio(id);
    }

    @PutMapping("/{id}")
    public StudioDTO updateStudio(@PathVariable final long id, @RequestBody CreateStudioDTO studio) {
        return studioService.updateStudio(id, studio);
    }

}
