package org.example.components.service;

import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;

import java.util.List;

public interface UnitTypeService {

    void createUnitType(UnitTypeCreateDto unitTypeCreateDto);

    List<UnitTypeDto> getUnitTypes();
}
