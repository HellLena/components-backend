package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.repository.UnitTypeRepository;
import org.example.components.service.UnitTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeService {

    private final UnitTypeRepository unitTypeRepository;

    @Override
    public void createUnitType(UnitTypeCreateDto unitTypeCreateDto) {
        unitTypeRepository.create(unitTypeCreateDto);
    }

    @Override
    public List<UnitTypeDto> getUnitTypes() {
        return unitTypeRepository.findAll();
    }
}
