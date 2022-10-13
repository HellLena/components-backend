package org.example.components.model.list;

import lombok.*;
import org.example.components.enumerations.CommonStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BomListDto {

    private Long id;
    private String designator;
    private String element;
    private String footprint;
    private int quantity;
    private boolean fitted;
    private boolean canBeReplaced;
    private CommonStatus status;

}
