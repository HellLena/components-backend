package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.domain.tables.records.ManufacturerRecord;
import org.example.components.mapper.ManufacturerMapper;
import org.example.components.model.ManufacturerDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep1;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;
import static org.example.components.domain.Tables.MANUFACTURER;
import static org.example.components.utils.RepositoryUtils.getSortedField;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ManufacturerRepository {

    private final DSLContext context;
    private final ManufacturerMapper mapper;

    public void create(ManufacturerCreateDto dto) {
        context
                .insertInto(MANUFACTURER)
                .columns(MANUFACTURER.NAME)
                .values(dto.getName())
                .execute();
    }


    public void batchCreate(Set<ManufacturerCreateDto> manufacturers) {
        InsertValuesStep1<ManufacturerRecord, String> step = context
                .insertInto(MANUFACTURER)
                .columns(MANUFACTURER.NAME);

        for (ManufacturerCreateDto dto : manufacturers) {
            step = step.values(dto.getName());
        }

        int inserted = step.onDuplicateKeyIgnore().execute();
        log.debug("{} manufacturers inserted", inserted);
    }

    public ManufacturerDto findByName(String name) {
        return context.selectFrom(MANUFACTURER)
                .where(MANUFACTURER.NAME.like(name))
                .fetchOne(mapper::fromRecord);
    }

    public void update(Long manufacturerId, UnitTypeCreateDto dto) {
        context
                .update(MANUFACTURER)
                .set(MANUFACTURER.NAME, dto.getName())
                .where(MANUFACTURER.ID.eq(manufacturerId))
                .execute();
    }

    public ManufacturerDto findById(Long manufacturerId) {
        return context.selectFrom(MANUFACTURER)
                .where(MANUFACTURER.ID.eq(manufacturerId))
                .fetchOne(mapper::fromRecord);
    }

    public List<ManufacturerDto> getAllPaged(SearchRequest request) {
        return context
                .selectFrom(MANUFACTURER)
                .orderBy(getSortedField(
                        ofNullable(request.getSortBy()).orElse(MANUFACTURER.NAME.getName()),
                        request.getOrder()))
                .offset(request.getPage() * request.getPageSize())
                .limit(request.getPageSize())
                .fetch(mapper::fromRecord);
    }
}
