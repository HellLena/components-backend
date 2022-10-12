package org.example.components.controller;

import lombok.RequiredArgsConstructor;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.service.ManufacturerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @PostMapping
    public void createManufacturer(@RequestBody @Valid ManufacturerCreateDto manufacturerCreateDto) {
        manufacturerService.createManufacturer(manufacturerCreateDto);
    }
}
