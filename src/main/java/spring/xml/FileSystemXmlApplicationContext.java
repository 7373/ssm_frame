package spring.xml;

import lombok.extern.slf4j.Slf4j;
import spring.factory.GenericBeanDefinition;

import java.util.Map;

/**
 *  @Author Yien
 */
@Slf4j
public class FileSystemXmlApplicationContext extends XmlApplicationContext {


    public  Map<String, GenericBeanDefinition> getGenericBeanDefinition(String contextConfigLocation){

        Map<String, GenericBeanDefinition>  genericBeanDefinition  = super.getBeanDefinitionMap(contextConfigLocation);

        return genericBeanDefinition;
    }
}


