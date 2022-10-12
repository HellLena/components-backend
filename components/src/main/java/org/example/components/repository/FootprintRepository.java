package org.example.components.repository;

import org.example.components.model.FootprintDto;
import org.example.components.model.create.FootprintCreateDto;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class FootprintRepository {

    //    private final DSLContext context;
    public void create(FootprintCreateDto footprintCreateDto) {
        // TODO
    }


    public void batchCreate(Set<FootprintCreateDto> footprints) {
        // TODO: batch insert (if exists - ignore)
    }

    public FootprintDto findByName(String name) {
        // TODO
        return null;
    }
}
