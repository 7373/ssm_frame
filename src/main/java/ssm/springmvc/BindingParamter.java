package ssm.springmvc;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;

/**
 * @ClassName BindingRoles
 * @Description
 * @Data 2018/12/6
 * @Author Yien
 */
public interface BindingParamter {

     Object bindingParamter(Parameter parameter, HttpServletRequest request) throws IllegalAccessException, InstantiationException, NoSuchMethodException;

}
