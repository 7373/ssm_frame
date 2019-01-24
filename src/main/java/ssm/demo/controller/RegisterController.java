package ssm.demo.controller;

import ssm.annotation.MyAutowired;
import ssm.annotation.MyController;
import ssm.annotation.MyRequestMapping;
import ssm.demo.service.RegisterService;
import ssm.demo.service.UserService;

/**
 * Created by Yien on 2018/12/21.
 */
@MyController
public class RegisterController {

    @MyAutowired
    private UserService userService;

    @MyAutowired
    private RegisterService registerService;

    @MyRequestMapping("/register")
    public void regeister(){
        userService.queryUser("","");
        registerService.register();
    }

}
