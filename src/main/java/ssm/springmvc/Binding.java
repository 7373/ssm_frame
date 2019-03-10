package ssm.springmvc;

import ssm.utils.AnnotationUtils;
import ssm.utils.ObjectUtils;
import ssm.utils.isBasicTypeUtils;
import ssm.annotation.MyModelAttribute;
import ssm.annotation.MyRequstParam;
import ssm.exception.springmvcException;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Binding：controller方法中绑定请求参数
 * @Description
 * @Data 2018/12/6
 * @Author Yien
 */
public class Binding {

    /**
     * bingdingMethodParamters :获取请求中发参数
     * @when
     */
    public static List<Object> bingdingMethodParamters(Map<String, Method> requestMappingMap, HttpServletRequest request) {
        List<Object> resultParameters = new ArrayList<>();
        Set<Map.Entry<String, Method>> entries = requestMappingMap.entrySet();
        for (Map.Entry<String, Method> entry : entries) {
            Method method = entry.getValue();
            Parameter[] parameters = method.getParameters();

            //pan kong
            for (Parameter parameter :
                    parameters) {
                if (ObjectUtils.isNotEmpty(parameter.getAnnotations())) {
                    Object resultParameter = null;
                    try {
                        resultParameter = bingdingEachParamter(parameter, request);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new springmvcException("绑定参数异常");
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                        throw new springmvcException("绑定参数异常");
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                        throw new springmvcException("绑定参数异常");
                    }
                    resultParameters.add(resultParameter);
                }
            }
        }
        return resultParameters;
    }


    private static Object bingdingEachParamter(Parameter parameter, HttpServletRequest request) throws IllegalAccessException, NoSuchMethodException, InstantiationException {

        //这里有问题
        if (ObjectUtils.isNotEmpty(parameter.getAnnotation(MyRequstParam.class))) {
            BindingParamter bindingParamter = new BindingByMyRequstParam();
            Object resultParameter = bindingParamter.bindingParamter(parameter, request);
            return resultParameter;
        } else if (ObjectUtils.isNotEmpty(parameter.getAnnotation(MyModelAttribute.class))) {
            BindingParamter bindingParamter = new BindingByMyModelAttribute();
            Object resultParameter = bindingParamter.bindingParamter(parameter, request);
            return resultParameter;
        } else if (parameter.getAnnotations() == null || parameter.getAnnotations().length == 0) {
            boolean flag = isBasicTypeUtils.isBasicType(parameter.getType().getSimpleName());
            if (flag) {
                BindingParamter bindingParamter = new BindingByMyRequstParam();
                Object resultParameter = bindingParamter.bindingParamter(parameter, request);
                return resultParameter;
            } else {
                BindingParamter bindingParamter = new BindingByMyModelAttribute();
                Object resultParameter = bindingParamter.bindingParamter(parameter, request);
                return resultParameter;
            }
        }
        return null;
    }

}
