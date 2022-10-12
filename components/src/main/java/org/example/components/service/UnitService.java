package org.example.components.service;

import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UnitService {

    void createUnit(UnitCreateDto unitCreateDto);

    List<UnitListDto> getUnits(int page, int pageSize, String sortBy, String orderBy);

    UnitDto getUnit(Long unitId);

    void updateUnit(Long unitId, UnitCreateDto unitCreateDto);

    void uploadBomFile(Long unitId, MultipartFile file);
}
