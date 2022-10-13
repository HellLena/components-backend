package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.ElementTypeDto;
import org.example.components.model.create.ElementTypeCreateDto;
import org.example.components.repository.ElementTypeRepository;
import org.example.components.service.ElementTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElementTypeServiceImpl implements ElementTypeService {

    private final ElementTypeRepository elementTypeRepository;

    @Override
    public void create(ElementTypeCreateDto dto) {
        elementTypeRepository.create(dto);
    }

    @Override
    public Long findIdByNameCached(Map<String, Long> elementTypes, String name) {
        if (elementTypes.containsKey(name)) {
            return elementTypes.get(name);
        }

        ElementTypeDto elementTypeDto = elementTypeRepository.findByName(name);
        elementTypes.put(elementTypeDto.getName(), elementTypeDto.getId());
        return elementTypeDto.getId();
    }

    @Override
    public void update(Long elementTypeId, ElementTypeCreateDto dto) {
        elementTypeRepository.update(elementTypeId, dto);
    }

    @Override
    public ElementTypeDto findById(Long elementTypeId) {
        return elementTypeRepository.findById(elementTypeId);
    }

    @Override
    public List<ElementTypeDto> getAllPaged(int page, int pageSize, String sortBy, String orderBy) {
        return elementTypeRepository.findAllPaged(page, pageSize, sortBy, orderBy);
    }
}
