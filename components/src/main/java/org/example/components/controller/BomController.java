package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.model.BomDto;
import org.example.components.model.create.BomCreateDto;
import org.example.components.model.list.BomListDto;
import org.example.components.service.BomService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/boms")
@RequiredArgsConstructor
@Tag(name = "BoM записи")
public class BomController {

    private final BomService bomService;

    @PostMapping
    @Operation(summary = "Создать элемент BoM")
    public void create(@RequestBody @Valid BomCreateDto dto) {
        bomService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить элемент BoM")
    public void update(@RequestParam("id") Long bomId,
                       @RequestBody @Valid BomCreateDto dto
    ) {
        bomService.update(bomId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить элемент BoM по id")
    public BomDto getById(@RequestParam("id") Long bomId) {
        return bomService.findById(bomId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех элементов BoM для указанной сборочной единицы постранично")
    public List<BomListDto> getAllPaged(
            @RequestParam(value = "_start", required = false, defaultValue = "0") int page,
            @RequestParam(value = "_end", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "_sort", required = false) String sortBy,
            @RequestParam(value = "_order", required = false) String orderBy,
            @RequestParam("id") Long unitId
    ) {
        return bomService.getAllPaged(page, pageSize, sortBy, orderBy, unitId);
    }
}
