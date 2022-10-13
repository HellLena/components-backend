package org.example.components.service;

import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UnitService {

    void create(UnitCreateDto dto);

    List<UnitListDto> getAllPaged(int page, int pageSize, String sortBy, String orderBy);

    UnitDto getById(Long unitId);

    void update(Long unitId, UnitCreateDto dto);

    void uploadBomFile(Long unitId, MultipartFile file);
}
