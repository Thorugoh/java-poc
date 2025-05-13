package com.thorugoh.cache.scheduler;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Log4j2
public class ScheduledCache {

    private static final Logger log = LoggerFactory.getLogger(ScheduledCache.class);

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    @CacheEvict("companies")
    public void cleanCompaniesCache(){
        log.info("Executing: {}", LocalDateTime.now());
    }
}
