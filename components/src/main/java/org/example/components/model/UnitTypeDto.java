package org.example.components.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Полное описание: тип сборочной единицы")
public class UnitTypeDto {

    @Schema(description = "Уникальный идентификатор типа сборочной единицы")
    private Long id;

    @Schema(description = "Наименование типа сборочной единицы")
    private String name;

}
