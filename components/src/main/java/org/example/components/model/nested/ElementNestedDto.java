package org.example.components.model.nested;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.components.enumerations.CommonStatus;

@Getter
@AllArgsConstructor
public class ElementNestedDto {

    private Long id;
    private String manufacturerNumber;
    private String description;
    private CommonStatus status;

}
