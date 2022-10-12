package org.example.components.model.create;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class UnitCreateDto {

    @NotNull
    private Long unitTypeId;

    @NotBlank
    private String decimalName;

}
