package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.domain.tables.records.ElementTypeRecord;
import org.example.components.mapper.ElementTypeMapper;
import org.example.components.model.ElementTypeDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.ElementTypeCreateDto;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep1;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;
import static org.example.components.domain.Tables.ELEMENT_TYPE;
import static org.example.components.utils.RepositoryUtils.getSortedField;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ElementTypeRepository {

    private final DSLContext context;
    private final ElementTypeMapper mapper;

    public void create(ElementTypeCreateDto dto) {
        context
                .insertInto(ELEMENT_TYPE)
                .columns(ELEMENT_TYPE.NAME)
                .values(dto.getName())
                .execute();
    }


    public void batchCreate(Set<ElementTypeCreateDto> elementTypes) {
        InsertValuesStep1<ElementTypeRecord, String> step = context
                .insertInto(ELEMENT_TYPE)
                .columns(ELEMENT_TYPE.NAME);

        for (ElementTypeCreateDto dto : elementTypes) {
            step = step.values(dto.getName());
        }

        int inserted = step.onDuplicateKeyIgnore().execute();
        log.debug("{} element types inserted", inserted);
    }

    public ElementTypeDto findByName(String bomType) {
        return context.selectFrom(ELEMENT_TYPE)
                .where(ELEMENT_TYPE.NAME.like(bomType))
                .fetchOne(mapper::fromRecord);
    }

    public void update(Long elementTypeId, ElementTypeCreateDto dto) {
        context
                .update(ELEMENT_TYPE)
                .set(ELEMENT_TYPE.NAME, dto.getName())
                .where(ELEMENT_TYPE.ID.eq(elementTypeId))
                .execute();
    }

    public ElementTypeDto findById(Long elementTypeId) {
        return context.selectFrom(ELEMENT_TYPE)
                .where(ELEMENT_TYPE.ID.eq(elementTypeId))
                .fetchOne(mapper::fromRecord);
    }

    public List<ElementTypeDto> findAllPaged(SearchRequest request) {
        return context
                .selectFrom(ELEMENT_TYPE)
                .orderBy(getSortedField(
                        ofNullable(request.getSortBy()).orElse(ELEMENT_TYPE.NAME.getName()),
                        request.getOrder()))
                .offset(request.getPage() * request.getPageSize())
                .limit(request.getPageSize())
                .fetch(mapper::fromRecord);
    }
}
