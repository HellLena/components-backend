package org.example.components.mapper;

import org.example.components.domain.tables.records.ElementRecord;
import org.example.components.enumerations.BomFileStatus;
import org.example.components.enumerations.CommonStatus;
import org.example.components.model.ElementDto;
import org.example.components.model.list.ElementListDto;
import org.jooq.Record5;
import org.jooq.Record6;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

import static java.util.Optional.ofNullable;

@Mapper(componentModel = "spring")
public interface ElementMapper {

    ElementDto fromRecord(ElementRecord record);

    @Mapping(target = "id", expression = "java(record6.value1())")
    @Mapping(target = "elementType", expression = "java(record6.value2())")
    @Mapping(target = "manufacturer", expression = "java(record6.value3())")
    @Mapping(target = "manufacturerNumber", expression = "java(record6.value4())")
    @Mapping(target = "description", expression = "java(record6.value5())")
    @Mapping(target = "status", expression = "java(getCommonStatus(record6.value6()))")
    ElementListDto fromRecord(Record6<Long, String, String, String, String, String> record6);

    default CommonStatus getCommonStatus(String status) {
        return ofNullable(status).map(CommonStatus::valueOf).orElse(null);
    }
}
