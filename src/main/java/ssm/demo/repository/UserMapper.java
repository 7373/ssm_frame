package ssm.demo.repository;

import ssm.demo.entity.User;

/**
 * @ClassName UserMapper
 * @Description
 * @Data 2018/12/6
 * @Author Yien
 */
public interface UserMapper {

    User queryUser(String userName,String passWord);

}
