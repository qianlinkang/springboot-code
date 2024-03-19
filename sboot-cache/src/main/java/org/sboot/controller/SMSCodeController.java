package org.sboot.controller;

import org.sboot.domain.SMSCode;
import org.sboot.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tele) {
        return smsCodeService.sendSMSCode(tele);
    }

    @PostMapping
    public Boolean checkCode(@RequestBody SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }

}
