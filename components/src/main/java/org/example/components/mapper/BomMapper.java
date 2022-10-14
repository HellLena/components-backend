package org.example.components.mapper;

import org.example.components.domain.tables.records.BomRecord;
import org.example.components.model.BomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BomMapper {

    BomDto fromRecord(BomRecord record);

}
