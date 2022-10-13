package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.model.ElementTypeDto;
import org.example.components.model.create.ElementTypeCreateDto;
import org.example.components.service.ElementTypeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/element-types")
@RequiredArgsConstructor
@Tag(name = "Типы элементов")
public class ElementTypeController {

    private final ElementTypeService elementTypeService;

    @PostMapping
    @Operation(summary = "Создать тип элемента")
    public void create(@RequestBody @Valid ElementTypeCreateDto dto) {
        elementTypeService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить тип элемента")
    public void update(@RequestParam("id") Long elementTypeId,
                       @RequestBody @Valid ElementTypeCreateDto dto
    ) {
        elementTypeService.update(elementTypeId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тип элемента по id")
    public ElementTypeDto getById(@RequestParam("id") Long elementTypeId) {
        return elementTypeService.findById(elementTypeId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех типов элементов постранично")
    public List<ElementTypeDto> getAllPaged(
            @RequestParam(value = "_start", required = false, defaultValue = "0") int page,
            @RequestParam(value = "_end", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "_sort", required = false) String sortBy,
            @RequestParam(value = "_order", required = false) String orderBy
    ) {
        return elementTypeService.getAllPaged(page, pageSize, sortBy, orderBy);
    }
}
