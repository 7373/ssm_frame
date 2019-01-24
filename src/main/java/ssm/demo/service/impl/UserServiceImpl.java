package ssm.demo.service.impl;

import ssm.annotation.MyAutowired;
import ssm.annotation.MyService;
import ssm.demo.entity.User;
import ssm.demo.repository.RegisterDao;
import ssm.demo.repository.UserDao;
import ssm.demo.repository.UserMapper;
import ssm.demo.service.UserService;

/**
 * Created by Yien on 2018/12/21.
 */
@MyService
public class UserServiceImpl implements UserService {

    @MyAutowired
    private UserDao userDao;

    @MyAutowired
    private RegisterDao registerDao;

    /*********************************/
    @MyAutowired
    private UserMapper userMapper;
    /*********************************/

    @Override
    public User queryUser(String userName, String passWord) {
        return userMapper.queryUser(userName,passWord);
    }
}
