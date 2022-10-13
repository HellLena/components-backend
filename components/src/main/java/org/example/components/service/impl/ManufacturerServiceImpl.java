package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.ManufacturerDto;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.example.components.repository.ManufacturerRepository;
import org.example.components.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public void create(ManufacturerCreateDto dto) {
        manufacturerRepository.create(dto);
    }

    @Override
    public Long findIdByNameCached(Map<String, Long> manufacturers, String name) {
        if (manufacturers.containsKey(name)) {
            return manufacturers.get(name);
        }

        ManufacturerDto dto = manufacturerRepository.findByName(name);
        manufacturers.put(dto.getName(), dto.getId());
        return dto.getId();
    }

    @Override
    public void update(Long manufacturerId, UnitTypeCreateDto dto) {
        manufacturerRepository.update(manufacturerId, dto);
    }

    @Override
    public ManufacturerDto findById(Long manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }

    @Override
    public List<ManufacturerDto> getAllPaged(int page, int pageSize, String sortBy, String orderBy) {
        return manufacturerRepository.getAllPaged(page, pageSize, sortBy, orderBy);
    }
}
