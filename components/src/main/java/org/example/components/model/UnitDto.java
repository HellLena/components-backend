package org.example.components.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.example.components.enumerations.BomStatus;

import java.time.LocalDateTime;

@Setter
@AllArgsConstructor
public class UnitDto {

    private Long id;
    private String unitType;
    private String decimalName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String bomFile;
    private String bomFileName;
    private BomStatus bomStatus;

}
