package com.oauth2phonepe.api;

import com.oauth2phonepe.dto.MerchantPayment;
import com.oauth2phonepe.dto.MerchantPaymentResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/phonepe")
public class PhonePeWalletApiController {
    @PostMapping(value = "/payMerchant",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public MerchantPaymentResponse payMerchant(@RequestBody MerchantPayment merchantPayment) {
        MerchantPaymentResponse response = null;

        response = MerchantPaymentResponse.of()
                .txNo(UUID.randomUUID().toString().substring(0, 8))
                .transactionDate(LocalDate.now())
                .phonePeAccountNo(merchantPayment.getPhonePeAccountNo())
                .merchantAccountNo(merchantPayment.getMerchantAccountNo())
                .amount(merchantPayment.getAmount())
                .status("CONFIRMED").build();

        return response;
    }


}
