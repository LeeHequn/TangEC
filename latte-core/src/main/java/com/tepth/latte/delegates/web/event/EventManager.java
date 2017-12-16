package com.tepth.latte.delegates.web.event;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.HashMap;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/12/13
 */

@SuppressWarnings("ALL")
public class EventManager {

    private static final HashMap<String, BaseEvent> EVENTS = new HashMap<>();

    private EventManager() {

    }

    private static class Holder {
        private static final EventManager INSTANCE = new EventManager();
    }

    public static EventManager getInstance() {
        return Holder.INSTANCE;
    }

    public EventManager addEvent(@NotNull String name, @NotNull BaseEvent event) {
        EVENTS.put(name, event);
        return this;
    }

    public BaseEvent createEvent(@NotNull String action) {
        final BaseEvent event = EVENTS.get(action);
        if (event == null) {
            return new UndefinedEvent();
        }
        return event;
    }
}
