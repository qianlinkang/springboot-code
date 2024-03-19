package org.sboot.service.impl;

import org.sboot.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private static final Logger log = LoggerFactory.getLogger(LogServiceImpl.class);

    @Override
    public String log() {
        log.debug("service debug...");
        log.info("service info...");
        log.warn("service warn...");
        log.error("service error...");
        return "log";
    }
}
