package org.example.components.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.service.ElementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/elements")
@RequiredArgsConstructor
public class ElementController {

    private final ElementService elementService;

    @PostMapping
    @Operation(summary = "Создать элемент")
    public void createElement(@RequestBody @Valid ElementCreateDto elementCreateDto) {
        elementService.createElement(elementCreateDto);
    }
}
