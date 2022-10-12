package org.example.components.controller;

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
    public void createUnit(@RequestBody @Valid UnitCreateDto unitCreateDto) {
        unitService.createUnit(unitCreateDto);
    }

    @GetMapping
    public List<UnitListDto> getUnits(@RequestParam("_start") int page,
                                      @RequestParam("_end") int pageSize,
                                      @RequestParam("_sort") String sortBy,
                                      @RequestParam("_order") String orderBy
    ) {
        return unitService.getUnits(page, pageSize, sortBy, orderBy);
    }

    @GetMapping("/{id}")
    public UnitDto getUnit(@RequestParam("id") Long unitId) {
        return unitService.getUnit(unitId);
    }

    @PutMapping("/{id}")
    public void updateUnit(@RequestParam("id") Long unitId,
                           @RequestBody @Valid UnitCreateDto unitCreateDto
    ) {
        unitService.updateUnit(unitId, unitCreateDto);
    }

    @PostMapping("/{id}/bom-upload")
    public void uploadBomFile(@RequestParam("id") Long unitId,
                              @RequestParam("file") MultipartFile file
    ) {
        unitService.uploadBomFile(unitId, file);
    }
}
