package org.example.components.model;

import lombok.*;
import org.example.components.enumerations.BomFileStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitDto {

    private Long id;
    private UnitTypeDto unitType;
    private String decimalName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String bomFile;
    private String bomFileName;
    private BomFileStatus bomFileStatus;

}
