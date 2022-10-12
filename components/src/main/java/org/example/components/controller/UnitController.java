package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.example.components.service.UnitService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/units")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @PostMapping
    @Operation(summary = "Создать сборочную единицу")
    public void createUnit(@RequestBody @Valid UnitCreateDto unitCreateDto) {
        unitService.createUnit(unitCreateDto);
    }

    @GetMapping
    @Operation(summary = "Получить список всех сборочных единиц постранично")
    public List<UnitListDto> getUnits(@RequestParam("_start") int page,
                                      @RequestParam("_end") int pageSize,
                                      @RequestParam("_sort") String sortBy,
                                      @RequestParam("_order") String orderBy
    ) {
        return unitService.getUnits(page, pageSize, sortBy, orderBy);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить сборочную единицу по id")
    public UnitDto getUnit(@RequestParam("id") Long unitId) {
        return unitService.getUnit(unitId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить сборочную единицу")
    public void updateUnit(@RequestParam("id") Long unitId,
                           @RequestBody @Valid UnitCreateDto unitCreateDto
    ) {
        unitService.updateUnit(unitId, unitCreateDto);
    }

    @PostMapping("/{id}/bom-upload")
    @Operation(summary = "Загрузить BoM файл для сборочной единицы")
    public void uploadBomFile(@RequestParam("id") Long unitId,
                              @RequestParam("file") MultipartFile file
    ) {
        unitService.uploadBomFile(unitId, file);
    }
}
