package ssm.annotation;

import ssm.xmlRules.RequestMethod;

import java.lang.annotation.*;

/**
 * Created by Yien on 2018/12/21.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {

    String value() default "";

    RequestMethod[] method() default {};

}


