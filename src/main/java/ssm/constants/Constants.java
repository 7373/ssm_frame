package ssm.constants;

import ssm.xml.FileSystemXmlApplicationContext;

/**
 * Created by Yien on 2018/12/21.
 * @Description :保存的是各个配置文件的路径
 */
public interface Constants {
    String PATH = FileSystemXmlApplicationContext.class.getResource("/").getPath();
    String contextConfigLocation = "application.xml";
    String springmvcConfigLocation = "spring-mvc.xml";
    String mybatisConfigLocation = "MyUserMapper.xml";
}


