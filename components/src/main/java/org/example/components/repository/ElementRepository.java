package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.domain.tables.records.ElementRecord;
import org.example.components.mapper.ElementMapper;
import org.example.components.model.ElementDto;
import org.example.components.model.ElementKey;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.model.list.ElementListDto;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep4;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.example.components.domain.Tables.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ElementRepository {

    private final DSLContext context;
    private final ElementMapper mapper;

    public void create(ElementCreateDto dto) {
        context
                .insertInto(ELEMENT)
                .columns(
                        ELEMENT.ELEMENT_TYPE_ID,
                        ELEMENT.MANUFACTURER_ID,
                        ELEMENT.MANUFACTURER_NUMBER,
                        ELEMENT.DESCRIPTION)
                .values(
                        dto.getElementTypeId(),
                        dto.getManufacturerId(),
                        dto.getManufacturerNumber(),
                        dto.getDescription())
                .execute();
    }


    public void batchCreate(Set<ElementCreateDto> elements) {
        InsertValuesStep4<ElementRecord, Long, Long, String, String> step = context
                .insertInto(ELEMENT)
                .columns(
                        ELEMENT.ELEMENT_TYPE_ID,
                        ELEMENT.MANUFACTURER_ID,
                        ELEMENT.MANUFACTURER_NUMBER,
                        ELEMENT.DESCRIPTION);

        for (ElementCreateDto dto : elements) {
            step = step.values(
                    dto.getElementTypeId(),
                    dto.getManufacturerId(),
                    dto.getManufacturerNumber(),
                    dto.getDescription());
        }

        int inserted = step.onDuplicateKeyIgnore().execute();
        log.debug("{} elements inserted", inserted);
    }

    public ElementDto findByKey(ElementKey elementKey) {
        // We should get only one element for this search.
        // That's why first we search by more prioritized manufacturer number and then by description.
        ElementDto dto = context.selectFrom(ELEMENT)
                .where(ELEMENT.MANUFACTURER_NUMBER.like(elementKey.getManufacturerNumber()))
                .fetchOne(mapper::fromRecord);

        if (Objects.nonNull(dto)) {
            log.debug("Element found by manufacturer number: {}", elementKey.getManufacturerNumber());
            return dto;
        }

        // We don't use here fulltext search because we need strict comparison for element
        return context.selectFrom(ELEMENT)
                .where(ELEMENT.DESCRIPTION.like(elementKey.getDescription()))
                .fetchOne(mapper::fromRecord);
    }

    public void update(Long elementTypeId, ElementCreateDto dto) {
        context.update(ELEMENT)
                .set(ELEMENT.ELEMENT_TYPE_ID, dto.getElementTypeId())
                .set(ELEMENT.MANUFACTURER_ID, dto.getManufacturerId())
                .set(ELEMENT.MANUFACTURER_NUMBER, dto.getManufacturerNumber())
                .set(ELEMENT.DESCRIPTION, dto.getDescription())
                .where(ELEMENT.ID.eq(elementTypeId))
                .execute();
    }

    public ElementDto findById(Long elementTypeId) {
        return context.selectFrom(ELEMENT)
                .where(ELEMENT.ID.eq(elementTypeId))
                .fetchOne(mapper::fromRecord);
    }

    public List<ElementListDto> findAllPaged(SearchRequest request) {
        return context.select(
                        ELEMENT.ID,
                        ELEMENT_TYPE.NAME,
                        MANUFACTURER.NAME,
                        ELEMENT.MANUFACTURER_NUMBER,
                        ELEMENT.DESCRIPTION,
                        ELEMENT.STATUS)
                .from(ELEMENT)
                .leftJoin(ELEMENT_TYPE).on(ELEMENT_TYPE.ID.eq(ELEMENT.ELEMENT_TYPE_ID))
                .leftJoin(MANUFACTURER).on(MANUFACTURER.ID.eq(ELEMENT.MANUFACTURER_ID))
                .orderBy(ELEMENT_TYPE.NAME.asc(), ELEMENT.MANUFACTURER_NUMBER.asc(), ELEMENT.DESCRIPTION.asc()) // TODO: use sortBy, orderBy
                .offset(request.getPage() * request.getPageSize())
                .limit(request.getPageSize())
                .fetch(mapper::fromRecord);
    }
}
