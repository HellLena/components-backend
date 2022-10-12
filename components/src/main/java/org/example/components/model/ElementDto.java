package org.example.components.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.components.enumerations.CommonStatus;

@Getter
@AllArgsConstructor
public class ElementDto {

    private Long id;
    private Long elementTypeId;
    private Long manufacturerId;
    private String manufacturerNumber;
    private String description;
    private CommonStatus status;

}
