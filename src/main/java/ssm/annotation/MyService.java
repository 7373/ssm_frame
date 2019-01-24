package ssm.annotation;

import java.lang.annotation.*;

/**
 * Created by Yien on 2018/12/21.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyService {
    String value() default "";
}


