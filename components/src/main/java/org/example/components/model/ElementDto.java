package org.example.components.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.components.enumerations.BomStatus;
import org.example.components.enumerations.CommonStatus;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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
