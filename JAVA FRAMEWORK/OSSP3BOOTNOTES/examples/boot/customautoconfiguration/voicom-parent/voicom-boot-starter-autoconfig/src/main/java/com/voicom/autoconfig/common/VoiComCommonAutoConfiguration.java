package com.voicom.autoconfig.common;

import com.voicom.common.ServerConnection;
import com.voicom.common.VoiComConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoiComCommonAutoConfiguration {

    @Bean
    @ConditionalOnClass(value = {ServerConnection.class})
    public ServerConnection serverConnection(@Value("${voiCom.voip.server.host}") String voipServer,
                                             @Value("${voiCom.voip.server.port}") int voipPort,
                                             @Value("${voiCom.voip.server.username}") String username,
                                             @Value("${voiCom.voip.server.password}") String password) {
        System.out.println("serverConnection created!");
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.setVoipServer(voipServer);
        serverConnection.setVoipPort(voipPort);
        serverConnection.setUsername(username);
        serverConnection.setPassword(password);

        return serverConnection;
    }

    @Bean
    @ConditionalOnClass(value = {VoiComConfig.class})
    public VoiComConfig voiComConfig(@Value("${voiCom.config.protocol}") String protocol,
                                     @Value("${voiCom.config.quality}") String quality,
                                     @Value("${voiCom.config.retries}") int retries) {
        System.out.println("voiComConfig created!");
        VoiComConfig voiComConfig = new VoiComConfig();
        voiComConfig.setProtocol(protocol);
        voiComConfig.setQuality(quality);
        voiComConfig.setRetries(retries);
        return voiComConfig;
    }


}
