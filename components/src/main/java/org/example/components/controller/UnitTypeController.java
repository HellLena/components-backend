package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.mapper.SearchRequestMapper;
import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.service.UnitTypeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/unit-types")
@RequiredArgsConstructor
@Tag(name = "Типы сборочных единиц")
public class UnitTypeController {

    private final UnitTypeService unitTypeService;
    private final SearchRequestMapper mapper;

    @PostMapping
    @Operation(summary = "Создать тип сборочной единицы")
    public UnitTypeDto create(@RequestBody @Valid UnitTypeCreateDto dto) {
        return unitTypeService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить тип сборочной единицы")
    public UnitTypeDto update(@PathVariable("id") Long unitTypeId,
                              @RequestBody @Valid UnitTypeDto dto
    ) {
        return unitTypeService.update(unitTypeId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тип сборочной единицы по id")
    public UnitTypeDto getById(@PathVariable("id") Long unitTypeId) {
        return unitTypeService.findById(unitTypeId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех типов сборочных единиц постранично")
    public List<UnitTypeDto> getAllPaged(@RequestParam(required = false) Map<String, String> request) {
        return unitTypeService.getAllPaged(mapper.toSearchRequest(request));
    }
}
