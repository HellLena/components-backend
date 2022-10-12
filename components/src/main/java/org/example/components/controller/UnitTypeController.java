package org.example.components.controller;

import lombok.RequiredArgsConstructor;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.service.UnitTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/unit-types")
@RequiredArgsConstructor
public class UnitTypeController {

    private final UnitTypeService unitTypeService;

    @PostMapping
    public void createUnitType(@RequestBody @Valid UnitTypeCreateDto unitTypeCreateDto) {
        unitTypeService.createUnitType(unitTypeCreateDto);
    }
}
