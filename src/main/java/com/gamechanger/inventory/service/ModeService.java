package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.Mode;
import com.gamechanger.inventory.repository.ModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeService {

    @Autowired
    private ModeRepository modeRepository;

    public Optional<Mode> getMode(final long id) { return modeRepository.findById(id); }

    public Iterable<Mode> getModes() { return modeRepository.findAll(); }

    public void deleteMode(final long id) { modeRepository.deleteById(id); }

    public Mode saveMode(Mode mode) { return modeRepository.save(mode); }
}
