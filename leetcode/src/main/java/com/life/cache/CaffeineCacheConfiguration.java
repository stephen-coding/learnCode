package com.life.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import com.github.benmanes.caffeine.cache.Weigher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author T596
 * @date 2023/8/8
 */
@Configuration
@ConditionalOnProperty(prefix = "cache", value = "type", havingValue = "caffeine", matchIfMissing = true)
@EnableCaching
@Slf4j
public class CaffeineCacheConfiguration {


    private final CacheSpecsMap configuration;


    public CaffeineCacheConfiguration(CacheSpecsMap configuration) {
        this.configuration = configuration;
    }

    @Bean
    public CacheManager cacheManager() {

        SimpleCacheManager manager = new SimpleCacheManager();
        if (configuration.getSpecsMap() != null) {

            List<CaffeineCache> caches = configuration.getSpecsMap().entrySet().stream()
                    .map(entry -> buildCache(entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
            manager.setCaches(caches);
        }
        //SimpleCacheManager is not a bean (will be wrapped), so call initializeCaches manually
        manager.initializeCaches();
        return manager;
    }

    private CaffeineCache buildCache(String name, CacheSpecs cacheSpec) {

        final Caffeine<Object, Object> caffeineBuilder
                = Caffeine.newBuilder()
                .weigher(collectionSafeWeigher())
                .maximumWeight(cacheSpec.getMaxSize())
                .expireAfterWrite(cacheSpec.getTimeToLiveInMinutes(), TimeUnit.MINUTES)
                .ticker(ticker());
        return new CaffeineCache(name, caffeineBuilder.build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }

    private Weigher<? super Object, ? super Object> collectionSafeWeigher() {
        return (Weigher<Object, Object>) (key, value) -> {
            if (value instanceof Collection) {
                return ((Collection) value).size();
            }
            return 1;
        };
    }
}
