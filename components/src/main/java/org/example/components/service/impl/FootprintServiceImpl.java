package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.FootprintDto;
import org.example.components.model.create.FootprintCreateDto;
import org.example.components.repository.FootprintRepository;
import org.example.components.service.FootprintService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FootprintServiceImpl implements FootprintService {

    private final FootprintRepository footprintRepository;

    @Override
    public void create(FootprintCreateDto dto) {
        footprintRepository.create(dto);
    }

    @Override
    public FootprintDto findByNameCached(Map<String, FootprintDto> footprints, String name) {
        if (footprints.containsKey(name)) {
            return footprints.get(name);
        }

        FootprintDto footprintDto = footprintRepository.findByName(name);
        footprints.put(footprintDto.getName(), footprintDto);
        return footprintDto;
    }

    @Override
    public void update(Long manufacturerId, FootprintCreateDto dto) {
        footprintRepository.update(manufacturerId, dto);
    }

    @Override
    public FootprintDto findById(Long manufacturerId) {
        return footprintRepository.findById(manufacturerId);
    }

    @Override
    public List<FootprintDto> getAllPaged(int page, int pageSize, String sortBy, String orderBy) {
        return footprintRepository.findAllPaged(page, pageSize, sortBy, orderBy);
    }
}
