package com.voicom.common;

import lombok.Data;

@Data
public class VoiComConfig {
    private String protocol;
    private String quality;
    private int retries;

}
