package org.example.components.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.components.enumerations.CommonStatus;

@Getter
@AllArgsConstructor
public class FootprintDto {

    private Long id;
    private String name;
    private CommonStatus status;

}
