package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.ElementTypeDto;
import org.example.components.model.create.ElementTypeCreateDto;
import org.example.components.repository.ElementTypeRepository;
import org.example.components.service.ElementTypeService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElementTypeServiceImpl implements ElementTypeService {

    private final ElementTypeRepository elementTypeRepository;

    @Override
    public void createElementType(ElementTypeCreateDto elementTypeCreateDto) {
        elementTypeRepository.create(elementTypeCreateDto);
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
}
