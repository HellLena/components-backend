package org.example.components.model.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.components.model.UnitTypeDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Создание: сборочная единица")
public class UnitCreateDto {

    @NotNull
    @Schema(description = "Тип сборочной единицы")
    private UnitTypeDto unitType;

    @NotBlank
    @Schema(description = "Децимальный номер")
    private String decimalName;

}
