package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.Studio;
import com.gamechanger.inventory.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public Optional<Studio> getStudio(final long id) { return studioRepository.findById(id); }

    public Iterable<Studio> getStudios() { return studioRepository.findAll(); }

    public void deleteStudio(final long id) { studioRepository.deleteById(id); }

    public Studio saveStudio(Studio studio) { return studioRepository.save(studio); }
}
