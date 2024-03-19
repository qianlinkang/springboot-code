package org.sboot.ssmp.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "移动端接口")
@RestController
@RequestMapping("/hello")
public class HelloController {


    @ApiOperation("hello")
    @GetMapping
    public String hello() {
        return "hello";
    }
}
