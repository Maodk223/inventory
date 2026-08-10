package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.model.Console;
import com.gamechanger.inventory.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @GetMapping
    public Iterable<Console> getConsoles() { return consoleService.getConsoles(); }

    @GetMapping("/{id}")
    public Console getConsole(@PathVariable final long id) {
        return consoleService.getConsole(id).orElse(null);
    }

    @PostMapping
    public Console createConsole(@RequestBody Console console) { return consoleService.saveConsole(console); }

    @DeleteMapping("/{id}")
    public void deleteConsole(@PathVariable final long id) {
        consoleService.deleteConsole(id);
    }

    @PutMapping("/{id}")
    public Console updateConsole(@PathVariable final long id, @RequestBody Console console) {
        Optional<Console> optionalConsole = consoleService.getConsole(id);
        if(optionalConsole.isEmpty()) return null;
        Console currentConsole = optionalConsole.get();

        String name = console.getName();
        if(name != null) currentConsole.setName(name);

        String alias = console.getAlias();
        if(alias != null) currentConsole.setAlias(alias);

        return consoleService.saveConsole(currentConsole);
    }



}
