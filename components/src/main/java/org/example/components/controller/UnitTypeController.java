package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.service.UnitTypeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/unit-types")
@RequiredArgsConstructor
public class UnitTypeController {

    private final UnitTypeService unitTypeService;

    @PostMapping
    @Operation(summary = "Создать тип сборочной единицы")
    public void createUnitType(@RequestBody @Valid UnitTypeCreateDto unitTypeCreateDto) {
        unitTypeService.createUnitType(unitTypeCreateDto);
    }

    @GetMapping
    @Operation(summary = "Получить список всех типов сборочных единиц")
    public List<UnitTypeDto> getUnitTypes() {
        return unitTypeService.getUnitTypes();
    }
}
