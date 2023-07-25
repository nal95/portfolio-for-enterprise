package com.nal95.portfolioforenterprise.service;

import com.nal95.portfolioforenterprise.model.Enterprise;
import com.nal95.portfolioforenterprise.repos.EnterpriseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class EnterprisesServiceImpl implements EnterprisesService {
    private final EnterpriseRepository enterprisesRepository;

    @Autowired
    public EnterprisesServiceImpl(EnterpriseRepository enterprisesRepository) {
        this.enterprisesRepository = enterprisesRepository;
    }

    @Override
    public Enterprise saveEnterprise(String enterpriseName) {

        Enterprise enterprise = new Enterprise();

        String token = UUID.randomUUID().toString();

        enterprise.setEnterpriseName(enterpriseName);
        enterprise.setEnterpriseToken(token);

        return enterprisesRepository.save(enterprise);
    }

    @Override
    public List<Enterprise> getAllEnterprises() {
        return enterprisesRepository.findAll();
    }

    @Override
    public Enterprise updateEnterpriseInfos(String token, String newName) {

        Enterprise enterprise = enterprisesRepository.findEnterpriseByEnterpriseToken(token).orElse(null);
        if (enterprise != null) {
            log.info("About to update this enterprise: " + enterprise);
            enterprise.setEnterpriseName(newName);
        }

        return enterprise;
    }
}
