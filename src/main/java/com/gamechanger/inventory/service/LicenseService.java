package com.gamechanger.inventory.service;

import com.gamechanger.inventory.dto.license.CreateLicenseDTO;
import com.gamechanger.inventory.dto.license.LicenseDTO;
import com.gamechanger.inventory.model.License;
import com.gamechanger.inventory.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    public Optional<LicenseDTO> getLicense(final long id) {
        return licenseRepository.findById(id).map(LicenseDTO::new);
    }

    public Optional<LicenseDTO> getLicense(final String name) {
        return licenseRepository.findByName(name).map(LicenseDTO::new);
    }

    public Iterable<LicenseDTO> getLicenses() {
        ArrayList<LicenseDTO> licenses = new ArrayList<>();
        licenseRepository.findAll().forEach(l -> licenses.add(new LicenseDTO(l)));
        return licenses;
    }

    public void deleteLicense(final long id) { licenseRepository.deleteById(id); }

    public LicenseDTO saveLicense(CreateLicenseDTO dto) {
        Optional<License> exist = licenseRepository.findByName(dto.getName());
        if (exist.isPresent())
            return new LicenseDTO(exist.get());

        License license = new License();
        license.setName(dto.getName());
        return new LicenseDTO(licenseRepository.save(license));
    }

    public LicenseDTO updateLicense(final long id, final CreateLicenseDTO dto) {
        License license = licenseRepository.findById(id).orElseThrow();
        license.setName(dto.getName());
        return new LicenseDTO(license);
    }
}
