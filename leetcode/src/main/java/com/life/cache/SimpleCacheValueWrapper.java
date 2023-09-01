package com.life.cache;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.cache.Cache;

/**
 * @author T596
 * @date 2023/8/9
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleCacheValueWrapper<T> implements CacheValueWrapper<T> {

    private final T value;


    @Override
    public T get() {
        return value;
    }

    public static <T> SimpleCacheValueWrapper<T> empty() {
        return new SimpleCacheValueWrapper<>(null);
    }

    public static <T> SimpleCacheValueWrapper<T> wrap(T value) {
        return new SimpleCacheValueWrapper<>(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> SimpleCacheValueWrapper<T> wrap(Cache.ValueWrapper resource) {
        return resource == null ? null : new SimpleCacheValueWrapper<>((T) resource.get());
    }
}
