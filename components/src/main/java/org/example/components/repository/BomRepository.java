package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.domain.tables.records.BomRecord;
import org.example.components.mapper.BomMapper;
import org.example.components.model.BomDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.BomCreateDto;
import org.example.components.model.list.BomListDto;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep8;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static org.example.components.domain.Tables.*;
import static org.jooq.impl.DSL.field;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BomRepository {

    private final DSLContext context;
    private final BomMapper mapper;

    public void create(BomCreateDto dto) {
        context
                .insertInto(BOM)
                .columns(
                        BOM.UNIT_ID,
                        BOM.DESIGNATOR,
                        BOM.ELEMENT_ID,
                        BOM.FOOTPRINT_ID,
                        BOM.FITTED,
                        BOM.CAN_BE_REPLACED,
                        BOM.STATUS)
                .values(
                        dto.getUnitId(),
                        dto.getDesignator(),
                        dto.getElementId(),
                        dto.getFootprintId(),
                        dto.isFitted(),
                        dto.isCanBeReplaced(),
                        dto.getStatus().name())
                .execute();
    }


    public void batchCreate(Set<BomCreateDto> boms) {
        InsertValuesStep8<BomRecord, Long, String, Long, Long, Integer, Boolean, Boolean, String> step = context
                .insertInto(BOM)
                .columns(
                        BOM.UNIT_ID,
                        BOM.DESIGNATOR,
                        BOM.ELEMENT_ID,
                        BOM.FOOTPRINT_ID,
                        BOM.QUANTITY,
                        BOM.FITTED,
                        BOM.CAN_BE_REPLACED,
                        BOM.STATUS);

        for (BomCreateDto dto : boms) {
            step = step.values(
                    dto.getUnitId(),
                    dto.getDesignator(),
                    dto.getElementId(),
                    dto.getFootprintId(),
                    dto.getQuantity(),
                    dto.isFitted(),
                    dto.isCanBeReplaced(),
                    dto.getStatus().name());
        }

        int inserted = step.onDuplicateKeyIgnore().execute();
        log.debug("{} elements inserted", inserted);
    }

    public void update(Long bomId, BomCreateDto dto) {
        context.update(BOM)
                .set(BOM.UNIT_ID, dto.getUnitId())
                .set(BOM.DESIGNATOR, dto.getDesignator())
                .set(BOM.ELEMENT_ID, dto.getElementId())
                .set(BOM.FOOTPRINT_ID, dto.getFootprintId())
                .set(BOM.QUANTITY, dto.getQuantity())
                .set(BOM.FITTED, dto.isFitted())
                .set(BOM.CAN_BE_REPLACED, dto.isCanBeReplaced())
                .where(BOM.ID.eq(bomId))
                .execute();
    }

    public BomDto findById(Long bomId) {
        return context.selectFrom(BOM)
                .where(BOM.ID.eq(bomId))
                .fetchOne(mapper::fromRecord);
    }

    public List<BomListDto> findAllPaged(Long unitId, SearchRequest request) {
        return context.select(
                        BOM.ID,
                        BOM.DESIGNATOR,
                        ELEMENT.ID.as("element.id"),
                        ELEMENT.MANUFACTURER_NUMBER.as("element.manufacturerNumber"),
                        ELEMENT.DESCRIPTION.as("element.description"),
                        ELEMENT.STATUS.as("element.status"),
                        FOOTPRINT.ID.as("footprint.id"),
                        FOOTPRINT.NAME.as("footprint.name"),
                        FOOTPRINT.STATUS.as("footprint.status"),
                        BOM.QUANTITY,
                        BOM.FITTED,
                        BOM.CAN_BE_REPLACED,
                        BOM.STATUS)
                .from(BOM)
                .leftJoin(ELEMENT).on(ELEMENT.ID.eq(BOM.ELEMENT_ID))
                .leftJoin(FOOTPRINT).on(FOOTPRINT.ID.eq(BOM.FOOTPRINT_ID))
                .where(BOM.UNIT_ID.eq(unitId))
                .orderBy(field("(substring(designator, '[a-zA-Z]+'))::text,  (substring(designator, '[0-9]+'))::int")) // TODO: use sortBy, orderBy
                .offset(request.getPage() * request.getPageSize())
                .limit(request.getPageSize())
                .fetchInto(BomListDto.class);
    }
}
