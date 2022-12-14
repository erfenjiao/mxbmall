/**
 *苦心人，天不负
 */
package ltd.mxb.mall.config.annotation;

import java.lang.annotation.*;

/**
 *  自定义 @TokenToMallUser 注解，使用注解和 AOP 方式将用户对象注入到方法中：
 *  使用方法参数解析器，在需要用户身份信息的方法中加上 @TokenToMallUser 注解，之后通过方法参数解析器来获得当前登录的对象信息。
 * */

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToAdminUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default "adminUser";

}
