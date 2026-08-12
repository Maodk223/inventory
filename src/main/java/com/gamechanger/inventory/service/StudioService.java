package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.studio.CreateStudioDTO;
import com.gamechanger.inventory.dto.studio.StudioDTO;
import com.gamechanger.inventory.model.Studio;
import com.gamechanger.inventory.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public Optional<StudioDTO> getStudio(final long id) { return studioRepository.findById(id).map(StudioDTO::new); }

    public Iterable<StudioDTO> getStudios() {
        ArrayList<StudioDTO> studios = new ArrayList<>();
        studioRepository.findAll().forEach(s->studios.add(new StudioDTO(s)));
        return studios;
    }

    public void deleteStudio(final long id) { studioRepository.deleteById(id); }

    public StudioDTO saveStudio(CreateStudioDTO dto) {
        Studio studio = new Studio();
        studio.setName(dto.getName());
        return new StudioDTO(studioRepository.save(studio));
    }

    public StudioDTO updateStudio(Long id, CreateStudioDTO dto) {
        Studio studio = studioRepository.findById(id).orElseThrow();
        studio.setName(dto.getName());
        return new StudioDTO(studioRepository.save(studio));
    }
}
