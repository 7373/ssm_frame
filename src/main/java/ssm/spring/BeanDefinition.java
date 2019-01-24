package ssm.spring;

import ssm.xml.XmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by Yien on 2018/12/1.
 * 没有什么实质性的作用，就是提供一个有很多种要注入到容器中的类，
 * 这里提供一个整合，需要获取时直接上这里来获取
 * 实例化前的准备
 */
public class BeanDefinition extends XmlApplicationContext {



    public List<String> getComponentList(String contextConfigLocation ){
        List<String> componentList = super.getComponentList(contextConfigLocation);
        return componentList;
    }

    public  Map<String, GenericBeanDefinition> getbeanDefinitionXmlMap(String contextConfigLocation){

        Map<String, GenericBeanDefinition>  getbeanDefinitionXmlMap  = super.getBeanDefinitionMap(contextConfigLocation);

        return getbeanDefinitionXmlMap;
    }
}


