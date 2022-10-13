package org.example.components.service;

import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;

import java.util.List;

public interface UnitTypeService {

    void create(UnitTypeCreateDto dto);

    List<UnitTypeDto> getAllPaged(int page, int pageSize, String sortBy, String orderBy);

    void update(Long unitTypeId, UnitTypeCreateDto dto);

    UnitTypeDto findById(Long unitTypeId);
}
