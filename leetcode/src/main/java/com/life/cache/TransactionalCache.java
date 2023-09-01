package com.life.cache;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author T596
 * @date 2023/8/9
 */

public interface TransactionalCache<K extends Serializable, V extends Serializable> {


    String getCacheName();

    CacheValueWrapper<V> get(K key);

    void put(K key, V value);

    void putIfAbsent(K key, V value);

    void evict(K key);

    void evict(Collection<K> keys);

    void evictOrPut(K key, V value);

    CacheTransaction<K, V> newTransactionForKey(K key);

}
