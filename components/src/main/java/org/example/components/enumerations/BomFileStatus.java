package org.example.components.enumerations;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BomFileStatus {
    NEW("новый"),
    PROCESSING("в обработке"),
    FAILED("ошибка"),
    MODERATION("на модерации"),
    APPROVED("подтверждён");

    private final String description;
}
