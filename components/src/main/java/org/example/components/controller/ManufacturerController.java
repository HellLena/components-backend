package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.mapper.SearchRequestMapper;
import org.example.components.model.ManufacturerDto;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.service.ManufacturerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manufacturers")
@RequiredArgsConstructor
@Tag(name = "Производители")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    private final SearchRequestMapper mapper;

    @PostMapping
    @Operation(summary = "Создать производителя")
    public void create(@RequestBody @Valid ManufacturerCreateDto dto) {
        manufacturerService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить производителя")
    public void update(@PathVariable("id") Long manufacturerId,
                       @RequestBody @Valid UnitTypeCreateDto dto
    ) {
        manufacturerService.update(manufacturerId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить производителя по id")
    public ManufacturerDto getById(@PathVariable("id") Long manufacturerId) {
        return manufacturerService.findById(manufacturerId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех производителей постранично")
    public List<ManufacturerDto> getAllPaged(@RequestParam(required = false) Map<String, String> request) {
        return manufacturerService.getAllPaged(mapper.toSearchRequest(request));
    }
}
