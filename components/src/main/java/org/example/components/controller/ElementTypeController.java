package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.components.model.create.ElementTypeCreateDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.service.ElementTypeService;
import org.example.components.service.UnitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/element-types")
@RequiredArgsConstructor
public class ElementTypeController {

    private final ElementTypeService elementTypeService;

    @PostMapping
    @Operation(summary = "Создать тип элемента")
    public void createElementType(@RequestBody @Valid ElementTypeCreateDto elementTypeCreateDto) {
        elementTypeService.createElementType(elementTypeCreateDto);
    }
}
