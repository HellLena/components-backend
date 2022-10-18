package org.example.components.model.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.components.enumerations.BomFileStatus;
import org.example.components.model.UnitTypeDto;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitListDto {

    private Long id;
    private UnitTypeDto unitType;
    private String decimalName;
    private BomFileStatus bomFileStatus;
    private LocalDateTime createdAt;

}
