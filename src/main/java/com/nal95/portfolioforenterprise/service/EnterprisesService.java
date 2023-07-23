package com.nal95.portfolioforenterprise.service;

import com.nal95.portfolioforenterprise.model.Enterprise;
import com.nal95.portfolioforenterprise.repos.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterprisesService {

    private final EnterpriseRepository enterprisesRepository;

    public EnterprisesService(EnterpriseRepository enterprisesRepository) {
        this.enterprisesRepository = enterprisesRepository;
    }

    public Enterprise saveEnterprise(Enterprise enterprise) {
        return enterprisesRepository.save(enterprise);
    }

    public List<Enterprise> getAllEnterprises() {
        return enterprisesRepository.findAll();
    }
}
