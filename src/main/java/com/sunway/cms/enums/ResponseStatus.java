package com.sunway.cms.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum ResponseStatus {
    FAIL,
    SUCCESS;
}