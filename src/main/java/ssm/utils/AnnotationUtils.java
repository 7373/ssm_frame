package ssm.utils;

/**
 * Created by Yien on 2018/12/21.
 * 注解工具类：判断注解是否为空
 */
public class  AnnotationUtils {

    public  static <T>  boolean isEmpty(T t){

        return  t == null ? true : false;

    }


}
