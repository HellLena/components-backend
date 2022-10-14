package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.example.components.service.UnitService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/units")
@RequiredArgsConstructor
@Tag(name = "Сборочные единицы")
public class UnitController {

    private final UnitService unitService;

    @PostMapping
    @Operation(summary = "Создать сборочную единицу")
    public void create(@RequestBody @Valid UnitCreateDto dto) {
        unitService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить сборочную единицу")
    public void update(@PathVariable("id") Long unitId,
                       @RequestBody @Valid UnitCreateDto dto
    ) {
        unitService.update(unitId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить сборочную единицу по id")
    public UnitDto getById(@PathVariable("id") Long unitId) {
        return unitService.getById(unitId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех сборочных единиц постранично")
    public List<UnitListDto> getAllPaged(
            @RequestParam(value = "_start", required = false, defaultValue = "0") int page,
            @RequestParam(value = "_end", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "_sort", required = false) String sortBy,
            @RequestParam(value = "_order", required = false) String order
    ) {
        return unitService.getAllPaged(page, pageSize, sortBy, order);
    }

    @PostMapping(value = "/{id}/bom-upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Загрузить BoM файл для сборочной единицы")
    public void uploadBomFile(@PathVariable("id") Long unitId,
                              @RequestParam("file") MultipartFile file
    ) {
        unitService.uploadBomFile(unitId, file);
    }
}
