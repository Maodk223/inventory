package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.model.License;
import com.gamechanger.inventory.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/licenses")
class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping
    public Iterable<License> getLicenses() { return licenseService.getLicenses(); }

    @GetMapping("/{id}")
    public License getLicense(@PathVariable final long id) {
        return licenseService.getLicense(id).orElse(null);
    }

    @PostMapping
    public License createLicense(@RequestBody License license) { return licenseService.saveLicense(license); }

    @DeleteMapping("/{id}")
    public void deleteLicense(@PathVariable final long id) {
        licenseService.deleteLicense(id);
    }

    @PutMapping("/{id}")
    public License updateLicense(@PathVariable final long id, @RequestBody License license) {
        Optional<License> optionalLicense = licenseService.getLicense(id);
        if(optionalLicense.isEmpty()) return null;
        License currentLicense = optionalLicense.get();

        String name = license.getName();
        if(name != null) currentLicense.setName(name);

        return licenseService.saveLicense(currentLicense);
    }

}
