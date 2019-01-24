package ssm.demo.service.impl;

import ssm.annotation.MyAutowired;
import ssm.annotation.MyService;
import ssm.demo.repository.RegisterDao;
import ssm.demo.service.RegisterService;

/**
 * Created by Yien on 2018/12/21.
 */
@MyService
public class RegisterServiceImpl implements RegisterService{

    @MyAutowired
    private RegisterDao registerDao;

    @Override
    public void register() {
        registerDao.register();
    }
}
