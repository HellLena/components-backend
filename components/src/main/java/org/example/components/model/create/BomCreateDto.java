package org.example.components.model.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.components.enumerations.CommonStatus;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BomCreateDto {

    @NotNull
    private Long unitId;
    @NotBlank
    private String designator;
    @NotNull
    private Long elementId;
    private Long footprintId;
    @Min(1)
    private int quantity;
    private boolean fitted;
    private boolean canBeReplaced;
    private CommonStatus status;

}
