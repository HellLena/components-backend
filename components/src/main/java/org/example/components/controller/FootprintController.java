package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.model.FootprintDto;
import org.example.components.model.create.FootprintCreateDto;
import org.example.components.service.FootprintService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/footprints")
@RequiredArgsConstructor
@Tag(name = "Посадочные места")
public class FootprintController {

    private final FootprintService footprintService;

    @PostMapping
    @Operation(summary = "Создать посадочное место")
    public void create(@RequestBody @Valid FootprintCreateDto dto) {
        footprintService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить посадочное место")
    public void update(@PathVariable("id") Long manufacturerId,
                       @RequestBody @Valid FootprintCreateDto dto
    ) {
        footprintService.update(manufacturerId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить посадочное место по id")
    public FootprintDto getById(@PathVariable("id") Long manufacturerId) {
        return footprintService.findById(manufacturerId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех посадочных мест постранично")
    public List<FootprintDto> getAllPaged(
            @RequestParam(value = "_start", required = false, defaultValue = "0") int page,
            @RequestParam(value = "_end", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "_sort", required = false) String sortBy,
            @RequestParam(value = "_order", required = false) String orderBy
    ) {
        return footprintService.getAllPaged(page, pageSize, sortBy, orderBy);
    }
}
