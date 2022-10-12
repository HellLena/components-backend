package org.example.components.model.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Schema(description = "Создание: тип элемента")
public class ElementTypeCreateDto {

    @NotBlank
    @Schema(description = "Наименование типа элемента")
    private String name;

}
