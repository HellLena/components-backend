package org.example.components.service;

import org.example.components.model.ElementDto;
import org.example.components.model.ElementKey;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.model.list.ElementListDto;

import java.util.List;
import java.util.Map;

public interface ElementService {

    void createElement(ElementCreateDto dto);

    ElementDto findByNameCached(Map<ElementKey, ElementDto> elements, ElementKey elementKey);

    void update(Long elementTypeId, ElementCreateDto dto);

    ElementDto findById(Long elementTypeId);

    List<ElementListDto> getAllPaged(int page, int pageSize, String sortBy, String orderBy);
}
