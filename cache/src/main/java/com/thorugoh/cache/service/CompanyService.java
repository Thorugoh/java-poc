package com.thorugoh.cache.service;

import com.thorugoh.cache.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.thorugoh.cache.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Cacheable("companies")
    public List<Company> findAll(){
        return (List<Company>) companyRepository.findAll();
    }
}
