package org.example.components.model.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@Schema(description = "Создание: тип сборочной единицы")
public class UnitTypeCreateDto {

    @NotBlank
    @Schema(description = "Наименование типа сборочной единицы")
    private String name;

}
