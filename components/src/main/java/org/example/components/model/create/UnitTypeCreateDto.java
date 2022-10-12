package org.example.components.model.create;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
public class UnitTypeCreateDto {

    @NotBlank
    private String name;

}
