package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.model.ElementDto;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.model.list.ElementListDto;
import org.example.components.service.ElementService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/elements")
@RequiredArgsConstructor
@Tag(name = "Элементы")
public class ElementController {

    private final ElementService elementService;

    @PostMapping
    @Operation(summary = "Создать элемент")
    public void create(@RequestBody @Valid ElementCreateDto dto) {
        elementService.createElement(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить элемент")
    public void update(@RequestParam("id") Long elementTypeId,
                       @RequestBody @Valid ElementCreateDto dto
    ) {
        elementService.update(elementTypeId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить элемент по id")
    public ElementDto getById(@RequestParam("id") Long elementTypeId) {
        return elementService.findById(elementTypeId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех элементов постранично")
    public List<ElementListDto> getAllPaged(
            @RequestParam(value = "_start", required = false, defaultValue = "0") int page,
            @RequestParam(value = "_end", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "_sort", required = false) String sortBy,
            @RequestParam(value = "_order", required = false) String orderBy
    ) {
        return elementService.getAllPaged(page, pageSize, sortBy, orderBy);
    }
}
