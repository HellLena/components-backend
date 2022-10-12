package org.example.components.repository;

import org.example.components.model.ElementDto;
import org.example.components.model.ElementKey;
import org.example.components.model.create.ElementCreateDto;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ElementRepository {

    //    private final DSLContext context;
    public void create(ElementCreateDto elementCreateDto) {
        // TODO
    }


    public void batchCreate(Set<ElementCreateDto> elements) {
        // TODO: batch insert (if exists - ignore)
    }

    public ElementDto findByKey(ElementKey elementKey) {
        // TODO: batch insert (if exists - ignore)
        return null;
    }
}
