package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.mode.CreateModeDTO;
import com.gamechanger.inventory.dto.mode.ModeDTO;
import com.gamechanger.inventory.model.Mode;
import com.gamechanger.inventory.repository.ModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ModeService {

    @Autowired
    private ModeRepository modeRepository;

    public Optional<ModeDTO> getMode(final long id) { return modeRepository.findById(id).map(ModeDTO::new); }

    public Iterable<ModeDTO> getModes() {
        ArrayList<ModeDTO> modes = new ArrayList<>();
        modeRepository.findAll().forEach(m -> modes.add(new ModeDTO(m)));
        return modes;
    }

    public void deleteMode(final long id) { modeRepository.deleteById(id); }

    public ModeDTO saveMode(CreateModeDTO dto) {
        Mode mode = new Mode();
        mode.setName(dto.getName());
        return new ModeDTO(modeRepository.save(mode));
    }

    public ModeDTO updateMode(final long id, CreateModeDTO dto) {
        Mode mode = modeRepository.findById(id).orElseThrow();
        mode.setName(dto.getName());
        return new ModeDTO(modeRepository.save(mode));
    }
}
