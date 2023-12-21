package com.life.cache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @author T596
 * @date 2023/8/9
 */
@Slf4j
@RequiredArgsConstructor
public class CaffeineCacheTransaction<K extends Serializable, V extends Serializable> implements CacheTransaction<K, V> {

    @Getter
    private final UUID uuid = UUID.randomUUID();

    private final CaffeineTransactionalCache<K, V> cache;

    @Getter
    private final List<K> keys;

    @Getter
    @Setter
    private boolean fail;


    @Override
    public void putIfAbsent(K key, V value) {

    }

    @Override
    public boolean commit() {
        return false;
    }

    @Override
    public void rollback() {

    }
}
