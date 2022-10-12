package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import org.example.components.enumerations.BomFileStatus;
import org.example.components.mapper.UnitMapper;
import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.example.components.domain.Tables.UNIT;
import static org.example.components.domain.Tables.UNIT_TYPE;

@Repository
@RequiredArgsConstructor
public class UnitRepository {

    private final DSLContext context;
    private final UnitMapper mapper;

    public void create(UnitCreateDto unitCreateDto) {
        context.insertInto(UNIT)
                .columns(UNIT.UNIT_TYPE_ID, UNIT.DECIMAL_NAME)
                .values(unitCreateDto.getUnitTypeId(), unitCreateDto.getDecimalName())
                .execute();
    }


    public List<UnitListDto> findAllPaged(int page, int pageSize, String sortBy, String orderBy) {
        return context.select(UNIT.ID, UNIT_TYPE.NAME, UNIT.DECIMAL_NAME, UNIT.BOM_FILE_STATUS, UNIT.CREATED_AT)
                .from(UNIT)
                .leftJoin(UNIT_TYPE).on(UNIT_TYPE.ID.eq(UNIT.UNIT_TYPE_ID))
//                .orderBy() // TODO
                .offset(page * pageSize)
                .limit(pageSize)
                .fetch(mapper::fromRecord);
    }

    public UnitDto findById(Long unitId) {
        return context.selectFrom(UNIT)
                .where(UNIT.ID.eq(unitId))
                .fetchOne(mapper::fromRecord);
    }

    public void update(Long unitId, UnitCreateDto unitCreateDto) {
        context.update(UNIT)
                .set(UNIT.UNIT_TYPE_ID, unitCreateDto.getUnitTypeId())
                .set(UNIT.DECIMAL_NAME, unitCreateDto.getDecimalName())
                .where(UNIT.ID.eq(unitId))
                .execute();
    }

    public void updateBomFile(Long unitId, String bomFile, String bomFileName, BomFileStatus bomFileStatus) {
        // TODO
    }

    public void updateBomFileStatus(Long unitId, BomFileStatus bomFileStatus) {
        // TODO
    }
}
