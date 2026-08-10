package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.model.Mode;
import com.gamechanger.inventory.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/modes")
public class ModeController {

    @Autowired
    private ModeService modeService;

    @GetMapping
    public Iterable<Mode> getModes() { return modeService.getModes(); }

    @GetMapping("/{id}")
    public Mode getMode(@PathVariable final long id) {
        return modeService.getMode(id).orElse(null);
    }

    @PostMapping
    public Mode createMode(@RequestBody Mode mode) { return modeService.saveMode(mode); }

    @DeleteMapping("/{id}")
    public void deleteMode(@PathVariable final long id) {
        modeService.deleteMode(id);
    }

    @PutMapping("/{id}")
    public Mode updateMode(@PathVariable final long id, @RequestBody Mode mode) {
        Optional<Mode> optionalMode = modeService.getMode(id);
        if(optionalMode.isEmpty()) return null;
        Mode currentMode = optionalMode.get();

        String name = mode.getName();
        if(name != null) currentMode.setName(name);

        return modeService.saveMode(currentMode);
    }

}
