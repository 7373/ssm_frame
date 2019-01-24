package ssm.spring.context;

import javax.servlet.ServletContext;

/**
 * *********************************************************************
 * <br/>
 * *********************************************************************
 */
public class ContextLoader {

    public ContextLoader() {
    }

    public void initWebApplicationContext(ServletContext servletContext) throws IllegalStateException {
        /*获取AppilcationContext*/
        /*根据application.xml配置文件位置*/
        String location = servletContext.getInitParameter("contextConfigLocation");
        AbstractApplicationContext abstractApplicationContext = new AbstractApplicationContext(location);
        abstractApplicationContext.refresh();
    }
}
