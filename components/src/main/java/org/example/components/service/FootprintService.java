package org.example.components.service;

import org.example.components.model.FootprintDto;
import org.example.components.model.create.FootprintCreateDto;

import java.util.Map;

public interface FootprintService {

    void createFootprint(FootprintCreateDto footprintCreateDto);

    FootprintDto findByNameCached(Map<String, FootprintDto> footprints, String name);
}
