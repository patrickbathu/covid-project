package com.patrickbathu.covidfirebase.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
public class CleanCache {

    @Autowired
    private CacheManager cacheManager; // autowire cache manager

    @Scheduled(cron = "0 0/2 * * * *")              // execure after every 30 min
    public void clearCacheSchedule(){
        log.info("CleanCache.clearCacheSchedule - start");
        for(String name : cacheManager.getCacheNames()){
            log.info("CleanCache.clearCacheSchedule key[{}] " , name );
            cacheManager.getCache(name).clear();            // clear cache by name
        }
        log.info("CleanCache.clearCacheSchedule - end");
    }
}
