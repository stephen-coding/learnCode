package com.life.cache;

/**
 * @author T596
 * @date 2023/8/9
 */
public interface CacheTransaction<K, V> {

    void putIfAbsent(K key, V value);

    boolean commit();

    void rollback();
}
