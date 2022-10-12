package org.example.components.model.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Создание: элемент")
public class ElementCreateDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор элемента")
    private Long elementTypeId;

    @Schema(description = "Уникальный идентификатор производителя")
    private Long manufacturerId;

    @Schema(description = "Уникальный идентификатор элемента у производителя")
    private String manufacturerNumber;

    @NotBlank
    @Schema(description = "Описание элемента (набор характеристик)")
    private String description;

}
