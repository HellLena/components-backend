package org.example.components.service;

import org.example.components.model.create.ManufacturerCreateDto;

import java.util.Map;

public interface ManufacturerService {

    void createManufacturer(ManufacturerCreateDto manufacturerCreateDto);

    Long findIdByNameCached(Map<String, Long> manufacturers, String bomManufacturer);
}
