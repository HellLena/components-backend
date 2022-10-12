package org.example.components.model;

import lombok.AllArgsConstructor;
import org.example.components.enumerations.CommonStatus;

@AllArgsConstructor
public class ManufacturerDto {

    private Long id;
    private String name;
    private CommonStatus status;

}
