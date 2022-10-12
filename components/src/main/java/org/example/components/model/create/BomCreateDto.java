package org.example.components.model.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.example.components.enumerations.CommonStatus;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Создание: BoM элемент")
public class BomCreateDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор сборочной единицы")
    private Long unitId;

    @NotBlank
    @Schema(description = "Позиционные номер")
    private String designator;

    @NotNull
    @Schema(description = "Уникальный идентификатор элемента")
    private Long elementId;

    @Schema(description = "Уникальный идентификатор посадочного места")
    private Long footprintId;

    @Min(1)
    @Schema(description = "Количество элементов")
    private int quantity;

    @Schema(description = "Флаг 'Устанавливать'")
    private boolean fitted;

    @Schema(description = "Флаг 'Можно заменить на аналог'")
    private boolean canBeReplaced;

    @Schema(description = "Статус BoM элемента (вычисляется автоматически на бэкенде)", hidden = true)
    private CommonStatus status;

}
