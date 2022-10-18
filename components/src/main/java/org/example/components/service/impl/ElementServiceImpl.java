package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.ElementDto;
import org.example.components.model.ElementKey;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.model.list.ElementListDto;
import org.example.components.repository.ElementRepository;
import org.example.components.service.ElementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository elementRepository;

    @Override
    public void createElement(ElementCreateDto dto) {
        elementRepository.create(dto);
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

    @Override
    public void update(Long elementTypeId, ElementCreateDto dto) {
        elementRepository.update(elementTypeId, dto);
    }

    @Override
    public ElementDto findById(Long elementTypeId) {
        return elementRepository.findById(elementTypeId);
    }

    @Override
    public List<ElementListDto> getAllPaged(SearchRequest request) {
        return elementRepository.findAllPaged(request);
    }
}
