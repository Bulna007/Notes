package com.callassist.service;

import com.voicom.core.VoiComAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallAssistService {
    @Autowired
    private VoiComAgent voiComAgent;

    public void call(String voipNumber) {
        boolean flag = voiComAgent.connect(voipNumber);
        System.out.println("call status : " + flag);
    }
}
