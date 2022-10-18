package org.example.components.service;

import org.example.components.model.FootprintDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.FootprintCreateDto;

import java.util.List;
import java.util.Map;

public interface FootprintService {

    void create(FootprintCreateDto dto);

    FootprintDto findByNameCached(Map<String, FootprintDto> footprints, String name);

    void update(Long manufacturerId, FootprintCreateDto dto);

    FootprintDto findById(Long manufacturerId);

    List<FootprintDto> getAllPaged(SearchRequest request);
}
