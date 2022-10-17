package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import org.example.components.mapper.UnitTypeMapper;
import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Optional.ofNullable;
import static org.example.components.domain.Tables.UNIT_TYPE;
import static org.example.components.utils.RepositoryUtils.getSortedField;

@Repository
@RequiredArgsConstructor
public class UnitTypeRepository {

    private final DSLContext context;
    private final UnitTypeMapper mapper;

    public UnitTypeDto create(UnitTypeCreateDto dto) {
        return context.insertInto(UNIT_TYPE)
                .columns(UNIT_TYPE.NAME)
                .values(dto.getName())
                .returning()
                .fetchOne()
                .into(UnitTypeDto.class);
    }


    public List<UnitTypeDto> findAllPaged(int page, int pageSize, String sortBy, String order) {
        return context
                .selectFrom(UNIT_TYPE)
                .orderBy(getSortedField(ofNullable(sortBy).orElse(UNIT_TYPE.NAME.getName()), order))
                .offset(page * pageSize)
                .limit(pageSize)
                .fetch(mapper::fromRecord);
    }

    public UnitTypeDto update(Long unitTypeId, UnitTypeDto dto) {
        return context
                .update(UNIT_TYPE)
                .set(UNIT_TYPE.NAME, dto.getName())
                .where(UNIT_TYPE.ID.eq(unitTypeId))
                .returning()
                .fetchOne()
                .into(UnitTypeDto.class);
    }

    public UnitTypeDto findById(Long unitTypeId) {
        return context.selectFrom(UNIT_TYPE)
                .where(UNIT_TYPE.ID.eq(unitTypeId))
                .fetchOne(mapper::fromRecord);
    }
}
