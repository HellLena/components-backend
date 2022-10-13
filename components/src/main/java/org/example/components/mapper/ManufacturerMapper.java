package org.example.components.mapper;

import org.example.components.domain.tables.records.ManufacturerRecord;
import org.example.components.model.ManufacturerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    ManufacturerDto fromRecord(ManufacturerRecord record);
}
