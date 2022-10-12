package org.example.components.model.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.components.enumerations.BomFileStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitListDto {

    private Long id;
    private String unitType;
    private String decimalName;
    private BomFileStatus bomFileStatus;
    private LocalDateTime createdAt;

}
