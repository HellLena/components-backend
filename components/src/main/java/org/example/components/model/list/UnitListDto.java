package org.example.components.model.list;

import lombok.AllArgsConstructor;
import org.example.components.enumerations.BomStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
public class UnitListDto {

    private Long id;
    private String unitType;
    private String decimalName;
    private BomStatus bomStatus;
    private LocalDateTime createdAt;

}
