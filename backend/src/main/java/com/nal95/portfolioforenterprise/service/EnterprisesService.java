package com.nal95.portfolioforenterprise.service;

import com.nal95.portfolioforenterprise.model.Enterprise;

import java.util.List;

public interface EnterprisesService {
    Enterprise saveEnterprise(String enterpriseName);

    List<Enterprise> getAllEnterprises();

    Enterprise updateEnterpriseInfos(String oldName, String newName);
}