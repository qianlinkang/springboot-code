package org.sboot.service;

import org.sboot.domain.SMSCode;

public interface SMSCodeService {

    String sendSMSCode(String tele);

    Boolean checkCode(SMSCode smsCode);

}
