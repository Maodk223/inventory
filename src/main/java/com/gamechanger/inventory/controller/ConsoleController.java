package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.console.ConsoleDTO;
import com.gamechanger.inventory.dto.console.CreateConsoleDTO;
import com.gamechanger.inventory.service.ConsoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Consoles")
@RequestMapping("/consoles")
class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @GetMapping
    public Iterable<ConsoleDTO> getConsoles() { return consoleService.getConsoles(); }

    @GetMapping("/{id}")
    public ConsoleDTO getConsole(@PathVariable final long id) {
        return consoleService.getConsole(id).orElse(null);
    }

    @PostMapping
    public ConsoleDTO createConsole(@RequestBody CreateConsoleDTO console) { return consoleService.saveConsole(console); }

    @DeleteMapping("/{id}")
    public void deleteConsole(@PathVariable final long id) {
        consoleService.deleteConsole(id);
    }

    @PutMapping("/{id}")
    public ConsoleDTO updateConsole(@PathVariable final long id, @RequestBody CreateConsoleDTO console) {
        return consoleService.updateConsole(id, console);
    }

}
