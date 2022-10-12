package org.example.components.service;

import org.example.components.model.ElementDto;
import org.example.components.model.ElementKey;
import org.example.components.model.create.ElementCreateDto;

import java.util.Map;

public interface ElementService {

    void createElement(ElementCreateDto elementCreateDto);

    ElementDto findByNameCached(Map<ElementKey, ElementDto> elements, ElementKey elementKey);
}
