package com.thorugoh.cache.service;

import com.thorugoh.cache.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CacheService {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CompanyService companyService;

    public void evictAllCacheValues(String cacheName){
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }

    @CachePut("companies")
    public List<Company> updateCompaniesCache(){
        return companyService.findAll();
    }

}
