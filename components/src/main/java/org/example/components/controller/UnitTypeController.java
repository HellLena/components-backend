package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Типы сборочных единиц")
public class UnitTypeController {

    private final UnitTypeService unitTypeService;

    @PostMapping
    @Operation(summary = "Создать тип сборочной единицы")
    public void create(@RequestBody @Valid UnitTypeCreateDto dto) {
        unitTypeService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить тип сборочной единицы")
    public void update(@PathVariable("id") Long unitTypeId,
                       @RequestBody @Valid UnitTypeCreateDto dto
    ) {
        unitTypeService.update(unitTypeId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тип сборочной единицы по id")
    public UnitTypeDto getById(@PathVariable("id") Long unitTypeId) {
        return unitTypeService.findById(unitTypeId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех типов сборочных единиц постранично")
    public List<UnitTypeDto> getAllPaged(
            @RequestParam(value = "_start", required = false, defaultValue = "0") int page,
            @RequestParam(value = "_end", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "_sort", required = false) String sortBy,
            @RequestParam(value = "_order", required = false) String order
    ) {
        return unitTypeService.getAllPaged(page, pageSize, sortBy, order);
    }
}
