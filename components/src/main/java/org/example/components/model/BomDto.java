package org.example.components.model;

import lombok.*;
import org.example.components.enumerations.BomFileStatus;
import org.example.components.enumerations.CommonStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BomDto {

    private Long id;
    private Long unitId;
    private String designator;
    private Long elementId;
    private Long footprintId;
    private int quantity;
    private boolean fitted;
    private boolean canBeReplaced;
    private CommonStatus status;

}
