package com.life.cache;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

/**
 * @author T596
 * @date 2023/8/8
 */
@Configuration
@ConfigurationProperties(prefix = "cache")
@Data
public class CacheSpecsMap {

    @Getter
    private Map<String, CacheSpecs> specsMap;
}
