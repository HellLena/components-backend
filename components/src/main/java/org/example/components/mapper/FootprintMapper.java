package org.example.components.mapper;

import org.example.components.domain.tables.records.FootprintRecord;
import org.example.components.model.FootprintDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FootprintMapper {

    FootprintDto fromRecord(FootprintRecord record);
}
