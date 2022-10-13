package org.example.components.mapper;

import org.example.components.domain.tables.records.ElementTypeRecord;
import org.example.components.model.ElementTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ElementTypeMapper {

    ElementTypeDto fromRecord(ElementTypeRecord elementTypeRecord);
}
