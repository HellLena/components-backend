package org.example.components.model.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Schema(description = "Создание: посадочное место")
public class FootprintCreateDto {

    @NotBlank
    @Schema(description = "Наименование посадочного места")
    private String name;

}
