package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.BomDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.BomCreateDto;
import org.example.components.model.list.BomListDto;
import org.example.components.repository.BomRepository;
import org.example.components.service.BomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BomServiceImpl implements BomService {

    private final BomRepository bomRepository;

    @Override
    public void create(BomCreateDto dto) {
        bomRepository.create(dto);
    }

    @Override
    public void update(Long bomId, BomCreateDto dto) {
        bomRepository.update(bomId, dto);
    }

    @Override
    public BomDto findById(Long bomId) {
        return bomRepository.findById(bomId);
    }

    @Override
    public List<BomListDto> getAllPaged(Long unitId, SearchRequest request) {
        return bomRepository.findAllPaged(unitId, request);
    }
}
