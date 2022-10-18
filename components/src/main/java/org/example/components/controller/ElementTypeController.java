package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.mapper.SearchRequestMapper;
import org.example.components.model.ElementTypeDto;
import org.example.components.model.create.ElementTypeCreateDto;
import org.example.components.service.ElementTypeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/element-types")
@RequiredArgsConstructor
@Tag(name = "Типы элементов")
public class ElementTypeController {

    private final ElementTypeService elementTypeService;
    private final SearchRequestMapper mapper;

    @PostMapping
    @Operation(summary = "Создать тип элемента")
    public void create(@RequestBody @Valid ElementTypeCreateDto dto) {
        elementTypeService.create(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить тип элемента")
    public void update(@PathVariable("id") Long elementTypeId,
                       @RequestBody @Valid ElementTypeCreateDto dto
    ) {
        elementTypeService.update(elementTypeId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тип элемента по id")
    public ElementTypeDto getById(@PathVariable("id") Long elementTypeId) {
        return elementTypeService.findById(elementTypeId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех типов элементов постранично")
    public List<ElementTypeDto> getAllPaged(@RequestParam(required = false) Map<String, String> request) {
        return elementTypeService.getAllPaged(mapper.toSearchRequest(request));
    }
}
