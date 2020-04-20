package com.woo.threadlearn.concurrent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class CopyOnWriteMap<K,V> implements Map<K,V>, Cloneable, Serializable {
    private volatile Map<K,V> map = new HashMap<>();

    public V put(K key, V value){
        synchronized (this){
            Map<K,V> newMap = new HashMap<>(map);
            V val = newMap.put(key, value);
            map = newMap;
            return val;
        }
    }

    public V get(Object key){
        return map.get(key);
    }

    public void putAll(Map<? extends K,? extends V> kvMap){
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(map);
            newMap.putAll(kvMap);
            map = newMap;
        }
    }
}
