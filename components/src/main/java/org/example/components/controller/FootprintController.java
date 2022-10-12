package org.example.components.controller;

import lombok.RequiredArgsConstructor;
import org.example.components.model.create.FootprintCreateDto;
import org.example.components.service.FootprintService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/footprints")
@RequiredArgsConstructor
public class FootprintController {

    private final FootprintService footprintService;

    @PostMapping
    public void createFootprint(@RequestBody @Valid FootprintCreateDto footprintCreateDto) {
        footprintService.createFootprint(footprintCreateDto);
    }
}
