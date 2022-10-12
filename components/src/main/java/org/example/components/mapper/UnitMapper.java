package org.example.components.mapper;

import org.example.components.domain.tables.records.UnitRecord;
import org.example.components.enumerations.BomFileStatus;
import org.example.components.model.UnitDto;
import org.example.components.model.list.UnitListDto;
import org.jooq.Record5;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

import static java.util.Optional.ofNullable;

@Mapper(componentModel = "spring")
public interface UnitMapper {

    UnitDto fromRecord(UnitRecord record);

    @Mapping(target = "id", expression = "java(record5.value1())")
    @Mapping(target = "unitType", expression = "java(record5.value2())")
    @Mapping(target = "decimalName", expression = "java(record5.value3())")
    @Mapping(target = "bomFileStatus", expression = "java(getBomFileStatus(record5.value4()))")
    @Mapping(target = "createdAt", expression = "java(record5.value5())")
    UnitListDto fromRecord(Record5<Long, String, String, String, LocalDateTime> record5);

    default BomFileStatus getBomFileStatus(String status) {
        return ofNullable(status).map(BomFileStatus::valueOf).orElse(null);
    }

}
