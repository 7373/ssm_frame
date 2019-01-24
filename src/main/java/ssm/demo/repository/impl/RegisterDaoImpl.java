package ssm.demo.repository.impl;

import ssm.annotation.MyRepository;
import ssm.demo.repository.RegisterDao;

/**
 * Created by Yien on 2018/12/21.
 */
@MyRepository
public class RegisterDaoImpl implements RegisterDao{

    @Override
    public void register() {
        System.out.println("我是RegisterDao");
    }
}
