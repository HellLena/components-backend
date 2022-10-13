package org.example.components.model.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.components.enumerations.CommonStatus;

@Getter
@AllArgsConstructor
public class ElementListDto {

    private Long id;
    private String elementType;
    private String manufacturer;
    private String manufacturerNumber;
    private String description;
    private CommonStatus status;

}
