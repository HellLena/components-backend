package org.example.components.model.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ElementCreateDto {

    @NotNull
    private Long elementTypeId;
    private Long manufacturerId;
    private String manufacturerNumber;
    @NotBlank
    private String description;

}
