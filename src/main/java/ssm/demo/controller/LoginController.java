package ssm.demo.controller;

import ssm.annotation.MyAutowired;
import ssm.annotation.MyController;
import ssm.annotation.MyModelAttribute;
import ssm.annotation.MyRequestMapping;
import ssm.demo.entity.User;
import ssm.demo.service.UserService;
import ssm.springmvc.MyModelAndView;
import ssm.springmvc.MyModelMap;
import ssm.xmlRules.RequestMethod;

/**
 * Created by Yien on 2018/12/21.
 */
@MyController
public class LoginController {

    @MyAutowired
    private UserService userService;


    //测试用的@MyRequstParam(value = "userName") String userName,  @MyRequstParam(value = "passWord") Integer passWord
    //返回值只支持MyModelAndView，数据模型和视图模型相结合
    @MyRequestMapping(value = "/hello", method = RequestMethod.POST)
    public MyModelAndView login(@MyModelAttribute("User") User user) {

        MyModelAndView myModelAndView = new MyModelAndView("success");
        MyModelMap myModel = new MyModelMap();
        User user1 = userService.queryUser(user.getUserName(), user.getPassWord());
        myModel.addAttribute("user", user1.getUserName());
        myModelAndView.setModelMap(myModel);

        return myModelAndView;

    }

    @MyRequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String test() {
        return "success2";
    }

}
