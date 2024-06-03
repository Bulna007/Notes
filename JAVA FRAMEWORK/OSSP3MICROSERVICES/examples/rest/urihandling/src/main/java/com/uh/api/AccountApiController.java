package com.uh.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountApiController {

    @GetMapping(value = "/{accountNo}", produces = {MediaType.TEXT_PLAIN_VALUE})
    //@ResponseBody
    public String getAccountHolderName(@PathVariable("accountNo") String accountNo) {
        return "For accountNo : " + accountNo + " accountHolder is: James Anderson";
    }

    @GetMapping(value = "/{accountNo}/ifsc", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String getIFSCode(@PathVariable("accountNo") String accountNo, @RequestParam("branchName") Optional<String> branchName) {
        return "accountNo : " + accountNo + " branchName : " + branchName + " ifscode: I93309383";
    }

    @GetMapping("/{city}/atmLocator")
    public String atmLocator(@PathVariable("city") String city, @MatrixVariable("area") String area) {
        return "city : " + city + " area : " + area;
    }

    @PostMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
    public String openAccount(@RequestParam("accountHolderName") String accountHolderName,
                              @RequestParam("accountType") String accountType,
                              @RequestParam("mobileNo") String mobileNo,
                              @RequestHeader("referral") String referralCode) {
        return "accountHolderName : " + accountHolderName + " accountType : " + accountType + " mobileno : " + mobileNo + " referral : " + referralCode;
    }
}
