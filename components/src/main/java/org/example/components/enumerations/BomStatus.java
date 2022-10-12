package org.example.components.enumerations;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BomStatus {
    NEW("новый"),
    PROCESSING("в обработке"),
    MODERATION("на модерации"),
    APPROVED("подтверждён");

    private final String description;
}
