package com.life.cache;

import lombok.Data;

/**
 * @author T596
 * @date 2023/8/8
 */
@Data
public class CacheSpecs {

    private Integer timeToLiveInMinutes;
    private Integer maxSize;
}
