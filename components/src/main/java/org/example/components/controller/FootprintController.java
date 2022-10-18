package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.mapper.SearchRequestMapper;
import org.example.components.model.FootprintDto;
import org.example.components.model.create.FootprintCreateDto;
import org.example.components.service.FootprintService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/footprints")
@RequiredArgsConstructor
@Tag(name = "Посадочные места")
public class FootprintController {

    private final FootprintService footprintService;
    private final SearchRequestMapper mapper;

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
    public List<FootprintDto> getAllPaged(@RequestParam(required = false) Map<String, String> request) {
        return footprintService.getAllPaged(mapper.toSearchRequest(request));
    }
}
