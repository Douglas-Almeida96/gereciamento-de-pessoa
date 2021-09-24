package com.personapi.apirest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypePhone {
    MOBILE("mobile"),
    LOCAL("local");

    private final String description;
}
