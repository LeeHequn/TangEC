package com.tang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:Create package name and WeChat broadcast receiver template annotation code
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface AppRegisterGenerator {

    /**
     * Create package name
     *
     * @return package name
     */
    String packageName();

    /**
     * Create WeChat broadcast receiver template class
     *
     * @return WeChat broadcast receiver template class
     */
    Class<?> registerTemplate();
}
