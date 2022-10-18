package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import org.example.components.enumerations.BomFileStatus;
import org.example.components.mapper.UnitMapper;
import org.example.components.model.SearchRequest;
import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.example.components.domain.Tables.*;
import static org.example.components.enumerations.CommonStatus.MODERATION;
import static org.example.components.utils.RepositoryUtils.getSortedField;
import static org.jooq.SortOrder.DESC;

@Repository
@RequiredArgsConstructor
public class UnitRepository {

    private final DSLContext context;
    private final UnitMapper mapper;

    public void create(UnitCreateDto dto) {
        context.insertInto(UNIT)
                .columns(UNIT.UNIT_TYPE_ID, UNIT.DECIMAL_NAME)
                .values(dto.getUnitTypeId(), dto.getDecimalName())
                .execute();
    }


    public List<UnitListDto> findAllPaged(SearchRequest request) {
        return context.select(UNIT.ID, UNIT_TYPE.NAME, UNIT.DECIMAL_NAME, UNIT.BOM_FILE_STATUS, UNIT.CREATED_AT)
                .from(UNIT)
                .leftJoin(UNIT_TYPE).on(UNIT_TYPE.ID.eq(UNIT.UNIT_TYPE_ID))
                .orderBy(getSortedField(
                        ofNullable(request.getSortBy()).orElse(UNIT.CREATED_AT.getName()),
                        ofNullable(request.getOrder()).orElse(DESC)))
                .offset(request.getPage() * request.getPageSize())
                .limit(request.getPageSize())
                .fetch(mapper::fromRecord);
    }

    public UnitDto findById(Long unitId) {
        return context.select(UNIT.asterisk(),
                        UNIT_TYPE.ID.as("unitType.id"),
                        UNIT_TYPE.NAME.as("unitType.name"))
                .from(UNIT)
                .leftJoin(UNIT_TYPE).on(UNIT_TYPE.ID.eq(UNIT.UNIT_TYPE_ID))
                .where(UNIT.ID.eq(unitId))
                .fetchOneInto(UnitDto.class);
    }

    public void update(Long unitId, UnitCreateDto dto) {
        context.update(UNIT)
                .set(UNIT.UNIT_TYPE_ID, dto.getUnitTypeId())
                .set(UNIT.DECIMAL_NAME, dto.getDecimalName())
                .set(UNIT.UPDATED_AT, LocalDateTime.now())
                .where(UNIT.ID.eq(unitId))
                .execute();
    }

    public void updateBomFile(Long unitId, String bomFile, String bomFileName, BomFileStatus bomFileStatus) {
        context.update(UNIT)
                .set(UNIT.BOM_FILE, bomFile)
                .set(UNIT.BOM_FILE_NAME, bomFileName)
                .set(UNIT.BOM_FILE_STATUS, bomFileStatus.name())
                .set(UNIT.UPDATED_AT, LocalDateTime.now())
                .where(UNIT.ID.eq(unitId))
                .execute();
    }

    public void updateBomFileStatus(Long unitId, BomFileStatus bomFileStatus) {
        context.update(UNIT)
                .set(UNIT.BOM_FILE_STATUS, bomFileStatus.name())
                .set(UNIT.UPDATED_AT, LocalDateTime.now())
                .where(UNIT.ID.eq(unitId))
                .execute();
    }

    public void updateBomFileStatus(Long unitId) {
        boolean existsModerationRows = context.fetchExists(BOM, BOM.STATUS.eq(MODERATION.name()));
        updateBomFileStatus(unitId, existsModerationRows ? BomFileStatus.MODERATION : BomFileStatus.APPROVED);
    }
}
