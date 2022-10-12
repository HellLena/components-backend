package org.example.components.service;

import org.example.components.model.create.ElementTypeCreateDto;

import java.util.Map;

public interface ElementTypeService {

    void createElementType(ElementTypeCreateDto elementTypeCreateDto);

    Long findIdByNameCached(Map<String, Long> elementTypes, String bomType);
}
