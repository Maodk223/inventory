package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.mode.CreateModeDTO;
import com.gamechanger.inventory.dto.mode.ModeDTO;
import com.gamechanger.inventory.service.ModeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Modes")
@RequestMapping("/modes")
class ModeController {

    @Autowired
    private ModeService modeService;

    @GetMapping
    public Iterable<ModeDTO> getModes() { return modeService.getModes(); }

    @GetMapping("/{id}")
    public ModeDTO getMode(@PathVariable final long id) {
        return modeService.getMode(id).orElse(null);
    }

    @PostMapping
    public ModeDTO createMode(@RequestBody CreateModeDTO mode) { return modeService.saveMode(mode); }

    @DeleteMapping("/{id}")
    public void deleteMode(@PathVariable final long id) {
        modeService.deleteMode(id);
    }

    @PutMapping("/{id}")
    public ModeDTO updateMode(@PathVariable final long id, @RequestBody CreateModeDTO mode) {
        return modeService.updateMode(id, mode);
    }

}
