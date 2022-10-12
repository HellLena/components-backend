package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.FootprintDto;
import org.example.components.model.create.FootprintCreateDto;
import org.example.components.repository.FootprintRepository;
import org.example.components.service.FootprintService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class FootprintServiceImpl implements FootprintService {

    private final FootprintRepository footprintRepository;

    @Override
    public void createFootprint(FootprintCreateDto footprintCreateDto) {
        footprintRepository.create(footprintCreateDto);
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
}
