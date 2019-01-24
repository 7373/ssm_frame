package ssm.annotation;

import java.lang.annotation.*;

/**
 * Created by Yien on 2018/12/21.
 */
@Target({
    ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
    boolean required() default true;
}


