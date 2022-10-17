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
    public UnitTypeDto create(UnitTypeCreateDto dto) {
        return unitTypeRepository.create(dto);
    }

    @Override
    public List<UnitTypeDto> getAllPaged(int page, int pageSize, String sortBy, String order) {
        return unitTypeRepository.findAllPaged(page, pageSize, sortBy, order);
    }

    @Override
    public UnitTypeDto update(Long unitTypeId, UnitTypeDto dto) {
        return unitTypeRepository.update(unitTypeId, dto);
    }

    @Override
    public UnitTypeDto findById(Long unitTypeId) {
        return unitTypeRepository.findById(unitTypeId);
    }
}
