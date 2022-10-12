package org.example.components.repository;

import org.example.components.model.ElementTypeDto;
import org.example.components.model.create.ManufacturerCreateDto;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ManufacturerRepository {

    //    private final DSLContext context;
    public void create(ManufacturerCreateDto manufacturerCreateDto) {
        // TODO
    }


    public void batchCreate(Set<ManufacturerCreateDto> manufacturers) {
        // TODO: batch insert (if exists - ignore)
    }

    public ElementTypeDto findByName(String name) {
        // TODO
        return null;
    }
}
