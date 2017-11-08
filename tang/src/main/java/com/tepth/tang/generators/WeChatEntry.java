package com.tepth.tang.generators;

import com.tang.annotations.EntryGenerator;
import com.tepth.latte.wechat.templates.WXEntryTemplate;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */

@EntryGenerator(
        packageName = "com.tepth.tang",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
