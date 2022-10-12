package org.example.components.mapper;

import org.example.components.domain.tables.records.UnitTypeRecord;
import org.example.components.model.UnitTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitTypeMapper {

    UnitTypeDto fromRecord(UnitTypeRecord record);

}
