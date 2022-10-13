package org.example.components.repository;

import lombok.RequiredArgsConstructor;
import org.example.components.mapper.UnitTypeMapper;
import org.example.components.model.UnitTypeDto;
import org.example.components.model.create.UnitTypeCreateDto;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.example.components.domain.Tables.UNIT_TYPE;

@Repository
@RequiredArgsConstructor
public class UnitTypeRepository {

    private final DSLContext context;
    private final UnitTypeMapper mapper;

    public void create(UnitTypeCreateDto dto) {
        context.insertInto(UNIT_TYPE)
                .columns(UNIT_TYPE.NAME)
                .values(dto.getName())
                .execute();
    }


    public List<UnitTypeDto> findAllPaged(int page, int pageSize, String sortBy, String orderBy) {
        return context
                .selectFrom(UNIT_TYPE)
                .orderBy(UNIT_TYPE.NAME.asc()) // TODO: use sortBy, orderBy
                .offset(page * pageSize)
                .limit(pageSize)
                .fetch(mapper::fromRecord);
    }

    public void update(Long unitTypeId, UnitTypeCreateDto dto) {
        context
                .update(UNIT_TYPE)
                .set(UNIT_TYPE.NAME, dto.getName())
                .where(UNIT_TYPE.ID.eq(unitTypeId))
                .execute();
    }

    public UnitTypeDto findById(Long unitTypeId) {
        return context.selectFrom(UNIT_TYPE)
                .where(UNIT_TYPE.ID.eq(unitTypeId))
                .fetchOne(mapper::fromRecord);
    }
}
