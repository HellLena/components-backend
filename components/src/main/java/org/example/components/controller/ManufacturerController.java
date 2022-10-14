package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.model.ManufacturerDto;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.service.ManufacturerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/manufacturers")
@RequiredArgsConstructor
@Tag(name = "Производители")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

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
    public List<ManufacturerDto> getAllPaged(
            @RequestParam(value = "_start", required = false, defaultValue = "0") int page,
            @RequestParam(value = "_end", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "_sort", required = false) String sortBy,
            @RequestParam(value = "_order", required = false) String orderBy
    ) {
        return manufacturerService.getAllPaged(page, pageSize, sortBy, orderBy);
    }
}
