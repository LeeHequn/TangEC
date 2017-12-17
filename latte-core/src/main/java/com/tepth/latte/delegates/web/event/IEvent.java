package com.tepth.latte.delegates.web.event;

/**
 * Description:Web和原生交互的接口
 *
 * @author Hequn.Lee
 * @date 2017/12/13
 */

public interface IEvent {
    /**
     * Web和原生交互的方法
     *
     * @param params 执行的方法参数
     * @return 执行的结果
     */
    String execute(String params);
}
