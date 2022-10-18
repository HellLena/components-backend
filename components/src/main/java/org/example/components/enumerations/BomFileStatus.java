package org.example.components.enumerations;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BomFileStatus {
    NEW("новый"),
    PROCESSING("в обработке"),
    FAILED("ошибка"),
    MODERATION("на модерации"),
    APPROVED("подтверждён");

    private final String description;

    @JsonProperty
    public String getName() {
        return name();
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }
}
