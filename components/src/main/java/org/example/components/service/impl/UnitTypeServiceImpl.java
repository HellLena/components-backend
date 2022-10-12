package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.repository.UnitTypeRepository;
import org.example.components.service.UnitTypeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeService {

    private final UnitTypeRepository unitTypeRepository;

    @Override
    public void createUnitType(UnitTypeCreateDto unitTypeCreateDto) {
        unitTypeRepository.createUnitType(unitTypeCreateDto);
    }
}
