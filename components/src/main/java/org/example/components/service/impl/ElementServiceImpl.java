package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.ElementDto;
import org.example.components.model.ElementKey;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.repository.ElementRepository;
import org.example.components.service.ElementService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository elementRepository;

    @Override
    public void createElement(ElementCreateDto elementCreateDto) {
        elementRepository.create(elementCreateDto);
    }

    @Override
    public ElementDto findByNameCached(Map<ElementKey, ElementDto> elements, ElementKey elementKey) {
        if (elements.containsKey(elementKey)) {
            return elements.get(elementKey);
        }

        ElementDto elementTypeDto = elementRepository.findByKey(elementKey);
        elements.put(elementKey, elementTypeDto);
        return elementTypeDto;
    }
}
