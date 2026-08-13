package com.gamechanger.inventory.controller;

import com.gamechanger.inventory.dto.license.CreateLicenseDTO;
import com.gamechanger.inventory.dto.license.LicenseDTO;
import com.gamechanger.inventory.service.LicenseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Licenses")
@RequestMapping("/licenses")
class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping
    public Iterable<LicenseDTO> getLicenses() { return licenseService.getLicenses(); }

    @GetMapping("/{id}")
    public LicenseDTO getLicense(@PathVariable final long id) {
        return licenseService.getLicense(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public LicenseDTO getLicense(@PathVariable final String name) {
        return licenseService.getLicense(name).orElse(null);
    }

    @PostMapping
    public LicenseDTO createLicense(@RequestBody CreateLicenseDTO license) { return licenseService.saveLicense(license); }

    @DeleteMapping("/{id}")
    public void deleteLicense(@PathVariable final long id) {
        licenseService.deleteLicense(id);
    }

    @PutMapping("/{id}")
    public LicenseDTO updateLicense(@PathVariable final long id, @RequestBody CreateLicenseDTO license) {
        return licenseService.updateLicense(id, license);
    }

}
