package org.example.components.repository;

import org.example.components.model.create.BomCreateDto;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class BomRepository {

    //    private final DSLContext context;
    public void create(BomCreateDto bomCreateDto) {
        // TODO
    }


    public void batchCreate(Set<BomCreateDto> boms) {
        // TODO: batch insert (if exists - ignore)
    }
}
