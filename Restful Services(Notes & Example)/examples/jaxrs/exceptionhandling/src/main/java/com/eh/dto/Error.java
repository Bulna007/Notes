package com.eh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private String errorCode;
    private String errorMessage;

}
