package ssm.spring.context;

import ssm.spring.ApplicationContext;

/**
 * *********************************************************************
 * <br/>
 *
 * @author yien <br/>
 * @Title AbstractApplicationContext
 * @date 2019/1/24 15:09
 * *********************************************************************
 */
public class AbstractApplicationContext extends ApplicationContext {


    public AbstractApplicationContext(String contextConfigLocation) {
        super(contextConfigLocation);
    }


    /*spring载入方法*/
    public void refresh(){


    }


}
