package com.voicom.autoconfig.core;

import com.voicom.autoconfig.common.VoiComCommonAutoConfiguration;
import com.voicom.common.ServerConnection;
import com.voicom.common.VoiComConfig;
import com.voicom.core.VoiComAgent;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({VoiComCommonAutoConfiguration.class})
public class VoiComAgentAutoConfiguration {

    @Bean
    @ConditionalOnBean(name = {"serverConnection", "voiComConfig"})
    public VoiComAgent voiComAgent(ServerConnection serverConnection, VoiComConfig voiComConfig) {
        VoiComAgent voiComAgent = new VoiComAgent();
        voiComAgent.setServerConnection(serverConnection);
        voiComAgent.setVoiComConfig(voiComConfig);
        return voiComAgent;
    }
}
