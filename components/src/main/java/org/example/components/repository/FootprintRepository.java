package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.domain.tables.records.FootprintRecord;
import org.example.components.mapper.FootprintMapper;
import org.example.components.model.FootprintDto;
import org.example.components.model.SearchRequest;
import org.example.components.model.create.FootprintCreateDto;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep1;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;
import static org.example.components.domain.Tables.FOOTPRINT;
import static org.example.components.utils.RepositoryUtils.getSortedField;

@Slf4j
@Repository
@RequiredArgsConstructor
public class FootprintRepository {

    private final DSLContext context;
    private final FootprintMapper mapper;

    public void create(FootprintCreateDto dto) {
        context
                .insertInto(FOOTPRINT)
                .columns(FOOTPRINT.NAME)
                .values(dto.getName())
                .execute();
    }


    public void batchCreate(Set<FootprintCreateDto> footprints) {
        InsertValuesStep1<FootprintRecord, String> step = context
                .insertInto(FOOTPRINT)
                .columns(FOOTPRINT.NAME);

        for (FootprintCreateDto dto : footprints) {
            step = step.values(dto.getName());
        }

        int inserted = step.onDuplicateKeyIgnore().execute();
        log.debug("{} footprints inserted", inserted);
    }

    public FootprintDto findByName(String name) {
        return context.selectFrom(FOOTPRINT)
                .where(FOOTPRINT.NAME.like(name))
                .fetchOne(mapper::fromRecord);
    }

    public void update(Long manufacturerId, FootprintCreateDto dto) {
        context
                .update(FOOTPRINT)
                .set(FOOTPRINT.NAME, dto.getName())
                .where(FOOTPRINT.ID.eq(manufacturerId))
                .execute();
    }

    public FootprintDto findById(Long manufacturerId) {
        return context.selectFrom(FOOTPRINT)
                .where(FOOTPRINT.ID.eq(manufacturerId))
                .fetchOne(mapper::fromRecord);
    }

    public List<FootprintDto> findAllPaged(SearchRequest request) {
        return context
                .selectFrom(FOOTPRINT)
                .orderBy(getSortedField(
                        ofNullable(request.getSortBy()).orElse(FOOTPRINT.NAME.getName()),
                        request.getOrder()))
                .offset(request.getPage() * request.getPageSize())
                .limit(request.getPageSize())
                .fetch(mapper::fromRecord);
    }
}
