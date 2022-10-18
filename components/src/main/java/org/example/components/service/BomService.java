package org.example.components.service;

import org.example.components.model.BomDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.BomCreateDto;
import org.example.components.model.list.BomListDto;

import java.util.List;

public interface BomService {

    void create(BomCreateDto dto);

    void update(Long bomId, BomCreateDto dto);

    BomDto findById(Long bomId);

    List<BomListDto> getAllPaged(Long unitId, SearchRequest request);
}
