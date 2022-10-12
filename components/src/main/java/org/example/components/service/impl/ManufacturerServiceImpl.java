package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.ElementTypeDto;
import org.example.components.model.create.ElementTypeCreateDto;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.repository.ElementTypeRepository;
import org.example.components.repository.ManufacturerRepository;
import org.example.components.service.ElementTypeService;
import org.example.components.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public void createManufacturer(ManufacturerCreateDto manufacturerCreateDto) {
        manufacturerRepository.create(manufacturerCreateDto);
    }

    @Override
    public Long findIdByNameCached(Map<String, Long> manufacturers, String name) {
        if (manufacturers.containsKey(name)) {
            return manufacturers.get(name);
        }

        ElementTypeDto elementTypeDto = manufacturerRepository.findByName(name);
        manufacturers.put(elementTypeDto.getName(), elementTypeDto.getId());
        return elementTypeDto.getId();
    }
}
