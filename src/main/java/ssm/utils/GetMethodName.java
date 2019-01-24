package ssm.utils;

/**
 * @ClassName GetMethodName
 * @Description 根据属性名拼接set方法
 * @Data 2018/12/6
 * @Author Yien
 */
public class GetMethodName {
    public   static  String getSetMethodNameByField(String propertyName) {
        String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        return methodName;

    }

}
