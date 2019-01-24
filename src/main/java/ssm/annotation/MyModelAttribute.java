package ssm.annotation;

import java.lang.annotation.*;

/**
 * @ClassName MyModelAttribute
 * @Description 绑定对象用的注解
 * @Data 2018/12/6
 * @Author Yien
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyModelAttribute {

    String value() default "";

}
