package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.console.ConsoleDTO;
import com.gamechanger.inventory.dto.console.CreateConsoleDTO;
import com.gamechanger.inventory.model.Console;
import com.gamechanger.inventory.model.Platform;
import com.gamechanger.inventory.repository.ConsoleRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

    private final EntityManager entityManager;

    public ConsoleService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<ConsoleDTO> getConsole(final long id) {
        return  consoleRepository.findById(id).map(ConsoleDTO::new);
    }

    public Optional<ConsoleDTO> getConsole(final String name) {
        return  consoleRepository.findByName(name).map(ConsoleDTO::new);
    }

    public Optional<ConsoleDTO> getConsoleByAlias(final String alias) {
        return  consoleRepository.findByAlias(alias).map(ConsoleDTO::new);
    }

    public Iterable<ConsoleDTO> getConsoles() {
        ArrayList<ConsoleDTO> consoles = new ArrayList<>();
        consoleRepository.findAll().forEach(c->consoles.add(new ConsoleDTO(c)));
        return consoles;
    }

    public void deleteConsole(final long id) { consoleRepository.deleteById(id); }

    public ConsoleDTO saveConsole(CreateConsoleDTO dto) {
        Optional<Console> exist = consoleRepository.findByName(dto.getName());
        if (exist.isPresent())
            return new ConsoleDTO(exist.get());

        Console console = new Console();

        console.setName(dto.getName());
        console.setAlias(dto.getAlias());
        console.setPlatform(entityManager.getReference(Platform.class, dto.getPlatformId()));

        return new ConsoleDTO(consoleRepository.save(console));
    }

    public ConsoleDTO updateConsole(Long id, CreateConsoleDTO dto) {
        Console console = consoleRepository.findById(id).orElseThrow();

        console.setName(dto.getName());
        console.setAlias(dto.getAlias());
        console.setPlatform(entityManager.getReference(Platform.class, dto.getPlatformId()));

        return new ConsoleDTO(consoleRepository.save(console));
    }

}
