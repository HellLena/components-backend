package org.example.components.controller;

import lombok.RequiredArgsConstructor;
import org.example.components.model.create.BomCreateDto;
import org.example.components.service.BomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/boms")
@RequiredArgsConstructor
public class BomController {

    private final BomService bomService;

    @PostMapping
    public void createBom(@RequestBody @Valid BomCreateDto bomCreateDto) {
        bomService.createBom(bomCreateDto);
    }
}