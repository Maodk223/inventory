package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.Console;
import com.gamechanger.inventory.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

    public Optional<Console> getConsole(final long id) { return consoleRepository.findById(id); }

    public Iterable<Console> getConsoles() { return consoleRepository.findAll(); }

    public void deleteConsole(final long id) { consoleRepository.deleteById(id); }

    public Console saveConsole(Console console) { return consoleRepository.save(console); }
}
