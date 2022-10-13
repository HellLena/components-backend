package org.example.components.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ElementKey {

    private String manufacturerNumber;
    private String description;

}
