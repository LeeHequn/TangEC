package com.tepth.tang.generators;

import com.tang.annotations.AppRegisterGenerator;
import com.tepth.latte.wechat.templates.AppRegisterTemplate;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */
@AppRegisterGenerator(
        packageName = "com.tepth.tang",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
