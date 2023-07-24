package com.nal95.portfolioforenterprise.service;

import com.nal95.portfolioforenterprise.model.Enterprise;
import com.nal95.portfolioforenterprise.repos.EnterpriseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class EnterprisesServiceImplTest {

    @Mock
    private EnterpriseRepository enterpriseRepository;

    @InjectMocks
    private EnterprisesServiceImpl enterprisesServiceImpl;

    @Test
    void saveEnterprises() {
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("Adesso");
        enterprise.setEnterpriseToken("Adesso2023");

        when(enterpriseRepository.save(any())).thenReturn(enterprise);

        Enterprise savedEnterprise = enterprisesServiceImpl.saveEnterprise("Adesso");

        assertThat(savedEnterprise).isNotNull();
        assertThat(savedEnterprise.getEnterpriseName()).isEqualTo("Adesso");
        assertThat(savedEnterprise.getEnterpriseToken()).isEqualTo("Adesso2023");
    }

    @Test
    void getAllEnterprises() {

        Enterprise enterprise1 = new Enterprise();
        enterprise1.setEnterpriseName("Adesso1");
        enterprise1.setEnterpriseName("Adesso12345");

        List<Enterprise> enterpriseList = new ArrayList<>();

        enterpriseList.add(enterprise1);
        enterpriseList.add(enterprise1);
        enterpriseList.add(enterprise1);

        when(enterpriseRepository.findAll()).thenReturn(enterpriseList);

        List<Enterprise> enterpriseListResult = enterprisesServiceImpl.getAllEnterprises();

        assertThat(enterpriseListResult).isNotNull();
        assertThat(enterpriseListResult.size()).isEqualTo(3);
    }

    @Test
    void updateEnterpriseInfos() {

        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("Adesso");
        enterprise.setEnterpriseToken("Adesso2023");

        when(enterpriseRepository.findEnterpriseByEnterpriseToken("Adesso2023")).thenReturn(Optional.of(enterprise));

        Enterprise updatedEnterprise = enterprisesServiceImpl.updateEnterpriseInfos("Adesso2023", "Adesso SE");

        assertThat(updatedEnterprise).isNotNull();
        assertThat(updatedEnterprise.getEnterpriseName()).isEqualTo("Adesso SE");
        assertThat(updatedEnterprise.getEnterpriseToken()).isEqualTo("Adesso2023");
    }
}