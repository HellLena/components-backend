package org.example.components.service;

import org.example.components.model.ManufacturerDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.model.create.UnitTypeCreateDto;

import java.util.List;
import java.util.Map;

public interface ManufacturerService {

    void create(ManufacturerCreateDto dto);

    Long findIdByNameCached(Map<String, Long> manufacturers, String bomManufacturer);

    void update(Long manufacturerId, UnitTypeCreateDto dto);

    ManufacturerDto findById(Long manufacturerId);

    List<ManufacturerDto> getAllPaged(SearchRequest request);
}
