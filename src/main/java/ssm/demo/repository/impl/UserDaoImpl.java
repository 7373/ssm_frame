package ssm.demo.repository.impl;

import ssm.annotation.MyRepository;
import ssm.demo.repository.UserDao;

/**
 * Created by Yien on 2018/12/21.
 */
@MyRepository
public class UserDaoImpl implements UserDao {

    @Override
    public void test() {
        System.out.println("我是UserDao");
    }
}
