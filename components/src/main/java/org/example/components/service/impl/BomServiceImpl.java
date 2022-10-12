package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.model.create.BomCreateDto;
import org.example.components.repository.BomRepository;
import org.example.components.service.BomService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BomServiceImpl implements BomService {

    private final BomRepository bomRepository;

    @Override
    public void createBom(BomCreateDto bomCreateDto) {
        bomRepository.create(bomCreateDto);
    }
}
