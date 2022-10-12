package org.example.components.enumerations;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommonStatus {
    MODERATION("на модерации"),
    APPROVED("подтверждён");

    private final String description;
}
