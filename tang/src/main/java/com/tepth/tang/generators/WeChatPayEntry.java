package com.tepth.tang.generators;

import com.tang.annotations.PayEntryGenerator;
import com.tepth.latte.wechat.templates.WXPayEntryTemplate;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */

@PayEntryGenerator(
        packageName = "com.tepth.tang",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
