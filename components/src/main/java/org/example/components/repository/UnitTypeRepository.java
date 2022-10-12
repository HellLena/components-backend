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

    public void create(UnitTypeCreateDto unitTypeCreateDto) {
        context.insertInto(UNIT_TYPE)
                .columns(UNIT_TYPE.NAME)
                .values(unitTypeCreateDto.getName())
                .execute();
    }


    public List<UnitTypeDto> findAll() {
        return context
                .selectFrom(UNIT_TYPE)
                .fetch(mapper::fromRecord);
    }
}
