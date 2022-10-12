package org.example.components.model.create;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@AllArgsConstructor
public class ElementTypeCreateDto {

    @NotBlank
    private String name;

}
