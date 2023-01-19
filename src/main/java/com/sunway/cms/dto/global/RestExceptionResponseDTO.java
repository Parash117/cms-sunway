package com.sunway.cms.dto.global;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestExceptionResponseDTO {

    private String error;

    private String errorCode;

    private String message;

}
