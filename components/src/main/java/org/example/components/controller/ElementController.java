package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.components.mapper.SearchRequestMapper;
import org.example.components.model.ElementDto;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.model.list.ElementListDto;
import org.example.components.service.ElementService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elements")
@RequiredArgsConstructor
@Tag(name = "Элементы")
public class ElementController {

    private final ElementService elementService;
    private final SearchRequestMapper mapper;

    @PostMapping
    @Operation(summary = "Создать элемент")
    public void create(@RequestBody @Valid ElementCreateDto dto) {
        elementService.createElement(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить элемент")
    public void update(@PathVariable("id") Long elementTypeId,
                       @RequestBody @Valid ElementCreateDto dto
    ) {
        elementService.update(elementTypeId, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить элемент по id")
    public ElementDto getById(@PathVariable("id") Long elementTypeId) {
        return elementService.findById(elementTypeId);
    }

    @GetMapping
    @Operation(summary = "Получить список всех элементов постранично")
    public List<ElementListDto> getAllPaged(@RequestParam(required = false) Map<String, String> request) {
        return elementService.getAllPaged(mapper.toSearchRequest(request));
    }
}
