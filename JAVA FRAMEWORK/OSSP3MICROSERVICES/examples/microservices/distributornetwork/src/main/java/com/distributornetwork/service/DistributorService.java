package com.distributornetwork.service;

import com.distributornetwork.bean.NetworkSettings;
import com.distributornetwork.dto.Distributor;
import com.distributornetwork.exception.NotFoundException;
import com.distributornetwork.repositories.DistributorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DistributorService {
    private final DistributorRepository distributorRepository;
    private final NetworkSettings networkSettings;


    @Transactional(readOnly = true)
    public Distributor findDistributorByDistributorCode(String distributorCode) {
        return distributorRepository.findByDistributorCode(distributorCode).stream().map(
                e -> {
                    return Distributor.of().distributorCode(e.getDistributorCode())
                            .businessName(e.getDistributorBusinessName())
                            .proprietorName(e.getOwnerName())
                            .contactNo(e.getContactNo())
                            .emailAddress(e.getEmailAddress())
                            .networkSettings(networkSettings)
                            .build();
                }
        ).findFirst().orElseThrow(() -> new NotFoundException("distributor doesnt exist"));
    }
}
