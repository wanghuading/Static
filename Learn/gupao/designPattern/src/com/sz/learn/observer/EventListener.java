package com.sz.learn.observer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author whd
 * @Date 2018/4/30 14:01
 * @Description
 **/
public class EventListener {
    private Map<EventType, EventEntity> events = new HashMap<>();

    public void addLisenter(EventType eventType, Object target, Method callback) {
        addListener(eventType, new EventEntity(target, callback, null));
    }

    public void addListener(EventType eventType, EventEntity eventEntity) {
        if (!events.containsKey(eventType)) {
            events.put(eventType, eventEntity);
        }
    }

    public void trigger(EventType eventType) {
        try {
            EventEntity eventEntity = events.get(eventType);
            eventEntity.getTargetMethod().invoke(eventEntity.getTarget(), eventEntity.getMethodParam());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
