package org.example.components.repository;

import org.example.components.model.ElementTypeDto;
import org.example.components.model.create.ElementTypeCreateDto;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ElementTypeRepository {

    //    private final DSLContext context;
    public void create(ElementTypeCreateDto elementTypeCreateDto) {
        // TODO
    }


    public void batchCreate(Set<ElementTypeCreateDto> elementTypes) {
        // TODO: batch insert (if exists - ignore)
    }

    public ElementTypeDto findByName(String bomType) {
        // TODO
        return null;
    }
}
