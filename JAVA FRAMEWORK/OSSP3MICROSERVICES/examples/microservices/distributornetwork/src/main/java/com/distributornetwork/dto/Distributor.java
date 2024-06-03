package com.distributornetwork.dto;

import com.distributornetwork.bean.NetworkSettings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder(builderMethodName = "of")
public class Distributor {
    private String distributorCode;
    private String businessName;
    private String proprietorName;
    private String contactNo;
    private String emailAddress;
    private NetworkSettings networkSettings;
}
