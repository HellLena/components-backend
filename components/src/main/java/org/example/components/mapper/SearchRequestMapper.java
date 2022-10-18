package org.example.components.mapper;

import org.example.components.model.SearchRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface SearchRequestMapper {

    @Mapping(target = "page", source = "_start")
    @Mapping(target = "pageSize", source = "_end")
    @Mapping(target = "sortBy", source = "_sort")
    @Mapping(target = "order", source = "_order")
    @Mapping(target = "query", source = "q")
    SearchRequest toSearchRequest(Map<String, String> requestMap);

}
