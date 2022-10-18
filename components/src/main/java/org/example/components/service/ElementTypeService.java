package org.example.components.service;

import org.example.components.model.ElementTypeDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.ElementTypeCreateDto;

import java.util.List;
import java.util.Map;

public interface ElementTypeService {

    void create(ElementTypeCreateDto elementTypeCreateDto);

    Long findIdByNameCached(Map<String, Long> elementTypes, String bomType);

    void update(Long elementTypeId, ElementTypeCreateDto dto);

    ElementTypeDto findById(Long elementTypeId);

    List<ElementTypeDto> getAllPaged(SearchRequest request);
}
