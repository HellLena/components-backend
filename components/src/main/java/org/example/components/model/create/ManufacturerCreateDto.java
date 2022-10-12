package org.example.components.model.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Schema(description = "Создание: производитель")
public class ManufacturerCreateDto {

    @NotBlank
    @Schema(description = "Наименование производителя")
    private String name;

}
