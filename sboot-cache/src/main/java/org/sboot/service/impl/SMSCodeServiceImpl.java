package org.sboot.service.impl;

import org.sboot.domain.SMSCode;
import org.sboot.service.SMSCodeService;
import org.sboot.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    /**
     * CachePut: 只取不存
     * Cacheable: key取的是入参数据,value取的是方法返回值数据(第一次存入,之后从缓存中读取key相同的数据)
     * @param tele
     * @return
     */
    @Override
//    @Cacheable(value = "smsCode", key="#tele")
    @CachePut(value = "smsCode", key="#tele")
    public String sendSMSCode(String tele) {
        return codeUtils.generator(tele);
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        // 取出内存中key与code相同的验证码值进行比对
        // 相同返回true
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }
}
