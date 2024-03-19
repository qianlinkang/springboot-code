package org.sboot.controller;

import org.sboot.domain.ResponseResult;
import org.sboot.domain.User;
import org.sboot.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);

    }

    @GetMapping("/user/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }
}
