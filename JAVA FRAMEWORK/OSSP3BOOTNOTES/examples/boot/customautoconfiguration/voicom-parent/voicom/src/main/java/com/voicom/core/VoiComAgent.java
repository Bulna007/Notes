package com.voicom.core;

import com.voicom.common.ServerConnection;
import com.voicom.common.VoiComConfig;
import lombok.Setter;

@Setter
public class VoiComAgent {
    private ServerConnection serverConnection;
    private VoiComConfig voiComConfig;

    public boolean connect(String voipNumber) {
        System.out.println("connecting to the voip server using : " + serverConnection);

        System.out.println("establishing call with configuration : " + voiComConfig);
        System.out.println("call in progress...");

        return true;
    }

    public void disconnect() {
        System.out.println("dis-connecting the call....");
    }
}
