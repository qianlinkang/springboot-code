package org.sboot.service;

import org.sboot.domain.ResponseResult;
import org.sboot.domain.User;

public interface LoginService {

    ResponseResult login(User user);

    ResponseResult logout();
}
