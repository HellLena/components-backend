package org.example.components.repository;

import org.example.components.enumerations.BomStatus;
import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UnitRepository {

    //    private final DSLContext context;
    public void create(UnitCreateDto unitCreateDto) {
        // TODO
    }


    public List<UnitListDto> findAllPaged(int page, int pageSize, String sortBy, String orderBy) {
        return Collections.emptyList();
    }

    public UnitDto findById(Long unitId) {
        return null;
    }

    public void update(Long unitId, UnitCreateDto unitCreateDto) {
        // TODO
    }

    public void updateBomFile(Long unitId, String bomFile, String bomFileName, BomStatus bomStatus) {
        // TODO
    }

    public void updateBomFileStatus(Long unitId, BomStatus bomStatus) {
        // TODO
    }
}
