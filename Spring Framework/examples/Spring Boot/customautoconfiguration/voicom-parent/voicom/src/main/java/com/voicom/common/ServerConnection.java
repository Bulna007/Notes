package com.voicom.common;

import lombok.Data;

@Data
public class ServerConnection {
    private String voipServer;
    private int voipPort;
    private String username;
    private String password;


}
