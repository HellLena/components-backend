package org.example.components.model.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Создание: сборочная единица")
public class UnitCreateDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор типа сборочной единицы")
    private Long unitTypeId;

    @NotBlank
    @Schema(description = "Децимальный номер")
    private String decimalName;

}
