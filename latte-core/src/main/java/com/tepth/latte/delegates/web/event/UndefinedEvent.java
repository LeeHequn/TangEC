package com.tepth.latte.delegates.web.event;

import com.tepth.latte.utils.log.LatteLogger;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/12/15
 */

public class UndefinedEvent extends BaseEvent {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefinedEvent", params);
        return null;
    }
}
