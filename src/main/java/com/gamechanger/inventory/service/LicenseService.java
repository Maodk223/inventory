package com.gamechanger.inventory.service;

import com.gamechanger.inventory.model.License;
import com.gamechanger.inventory.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    public Optional<License> getLicense(final long id) { return licenseRepository.findById(id); }

    public Iterable<License> getLicenses() { return licenseRepository.findAll(); }

    public void deleteLicense(final long id) { licenseRepository.deleteById(id); }

    public License saveLicense(License license) { return licenseRepository.save(license); }
}
