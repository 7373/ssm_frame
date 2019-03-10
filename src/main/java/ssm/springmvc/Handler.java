package ssm.springmvc;

import lombok.extern.slf4j.Slf4j;
import ssm.utils.AnnotationUtils;
import ssm.annotation.MyController;
import ssm.annotation.MyRequestMapping;
import ssm.exception.springmvcException;
import ssm.utils.ObjectUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName Handler
 * @Description 遍历bean容器，在有controller注解的类中有requestmapping扫描的方法，则将方法和url和方法绑定
 * @Data 2018/12/3
 * @Author Yien
 */
@Slf4j
public class Handler {

    /**
     * beanContainerMap(bean容器中)-》找到MyController注解的bean-》寻找MyRequestMapping方法-》放入bindingRequestMapping
     *
     * @when
     */
    public static Map<String, Method> bindingRequestMapping(Map<String, Object> beanContainerMap) {
        Map<String, Method> handlerMapping = new ConcurrentHashMap<>();
        if (ObjectUtils.isNotEmpty(beanContainerMap)) {
            Set<Map.Entry<String, Object>> entries = beanContainerMap.entrySet();
            for (Map.Entry<String, Object> entry :
                    entries) {
                Class aClass = entry.getValue().getClass();
                Annotation annotation = aClass.getAnnotation(MyController.class);
                Method[] methods = aClass.getMethods();
                /**
                 * 满足2个条件：包含MyController类以及包含方法 Method
                 * @when
                 */
                if (ObjectUtils.isNotEmpty(annotation) && (ObjectUtils.isNotEmpty(methods))) {
                    for (Method method : aClass.getMethods()) {
                        MyRequestMapping requestMappingAnnotation = method.getAnnotation(MyRequestMapping.class);
                        if (ObjectUtils.isNotEmpty(requestMappingAnnotation)) {
                            /**
                             * 对应：@MyRequestMapping(value = "/hello")
                             * @when
                             */
                            String key = requestMappingAnnotation.value();
                            //   requestMappingAnnotation.method()  //对应method属性 以后可以完善功能 method = post/get
                            handlerMapping.put(key, method);
                        }
                    }
                }
            }
        } else {
            throw new springmvcException("beanContainerMap容器为空,停止扫描MyController"+beanContainerMap);
        }
        return handlerMapping;

    }

}
