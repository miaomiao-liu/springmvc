package com.atguigu.springmvc.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ResponseStatus ： 可以放在类上，也可以放在方法上
 * Created by miaomiao on 18-2-4.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户名和密码不匹配！")
public class UserNameNotMatchPasswordException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;


}
