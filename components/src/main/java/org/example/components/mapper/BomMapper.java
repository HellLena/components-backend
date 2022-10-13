package org.example.components.mapper;

import org.example.components.domain.tables.records.BomRecord;
import org.example.components.domain.tables.records.ElementRecord;
import org.example.components.enumerations.CommonStatus;
import org.example.components.model.BomDto;
import org.example.components.model.ElementDto;
import org.example.components.model.list.BomListDto;
import org.example.components.model.list.ElementListDto;
import org.jooq.Record6;
import org.jooq.Record8;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static java.util.Optional.ofNullable;

@Mapper(componentModel = "spring")
public interface BomMapper {

    BomDto fromRecord(BomRecord record);

    @Mapping(target = "id", expression = "java(record8.value1())")
    @Mapping(target = "designator", expression = "java(record8.value2())")
    @Mapping(target = "element", expression = "java(record8.value3())")
    @Mapping(target = "footprint", expression = "java(record8.value4())")
    @Mapping(target = "quantity", expression = "java(record8.value5())")
    @Mapping(target = "fitted", expression = "java(record8.value6())")
    @Mapping(target = "canBeReplaced", expression = "java(record8.value7())")
    @Mapping(target = "status", expression = "java(getCommonStatus(record8.value8()))")
    BomListDto fromRecord(Record8<Long, String, String, String, Integer, Boolean, Boolean, String> record8);

    default CommonStatus getCommonStatus(String status) {
        return ofNullable(status).map(CommonStatus::valueOf).orElse(null);
    }
}
