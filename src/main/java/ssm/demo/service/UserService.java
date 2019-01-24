package ssm.demo.service;

import ssm.demo.entity.User;

/**
 * Created by Yien on 2018/12/21.
 */
public interface UserService {

     User queryUser(String userName, String passWord);
}
