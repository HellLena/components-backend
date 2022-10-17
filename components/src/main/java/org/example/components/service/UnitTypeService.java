package org.example.components.service;

import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;

import java.util.List;

public interface UnitTypeService {

    UnitTypeDto create(UnitTypeCreateDto dto);

    List<UnitTypeDto> getAllPaged(int page, int pageSize, String sortBy, String order);

    UnitTypeDto update(Long unitTypeId, UnitTypeDto dto);

    UnitTypeDto findById(Long unitTypeId);
}
