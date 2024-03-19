package org.sboot.controller;

import org.sboot.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    @GetMapping
    public String log() {
        System.out.println("controller running...");
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        System.out.println("run service");
        logService.log();
        return "控制台打印日志";
    }
}
