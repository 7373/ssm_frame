package spring.demo.repository.impl;

import spring.annotation.MyRepository;
import spring.demo.repository.RegisterDao;
import spring.demo.service.RegisterService;

/**
 * Created by Yien on 2018/6/27.
 */
@MyRepository
public class RegisterDaoImpl implements RegisterDao{

    @Override
    public void register() {
        System.out.println("我是RegisterDao");
    }
}
