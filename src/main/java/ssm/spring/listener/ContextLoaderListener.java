package ssm.spring.listener;

import ssm.spring.context.ContextLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * *********************************************************************
 * <br/>
 *
 * @author yien <br/>
 * @Title ContextLoaderListener
 * @date 2019/1/24 15:06
 */
public class ContextLoaderListener implements ServletContextListener {
    private ContextLoader contextLoaderSingleton=null;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        this.contextLoaderSingleton = this.createContextLoader();
        this.contextLoaderSingleton.initWebApplicationContext(event.getServletContext());

    }

    /*这里不能保证单例*/
    protected synchronized ContextLoader createContextLoader() {
        if(null==contextLoaderSingleton) {
            return new ContextLoader();
        }
        return contextLoaderSingleton;
    }

    public ContextLoader getContextLoader() {
        return this.contextLoaderSingleton;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (this.contextLoaderSingleton != null) {
            contextLoaderSingleton=null;
        }
    }
}
