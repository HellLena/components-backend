package org.example.components.model.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BomDataWrapper {

    private Long unitId;
    private List<BomFileData> data;

}
