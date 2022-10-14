package org.example.components.model.list;

import lombok.*;
import org.example.components.enumerations.CommonStatus;
import org.example.components.model.FootprintDto;
import org.example.components.model.nested.ElementNestedDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BomListDto {

    private Long id;
    private String designator;
    private ElementNestedDto element;
    private FootprintDto footprint;
    private int quantity;
    private boolean fitted;
    private boolean canBeReplaced;
    private CommonStatus status;

}
