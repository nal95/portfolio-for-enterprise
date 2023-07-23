package com.nal95.portfolioforenterprise.service;

import com.nal95.portfolioforenterprise.model.Enterprise;
import com.nal95.portfolioforenterprise.repos.EnterpriseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
class EnterprisesServiceTest {
    @Mock
    private EnterpriseRepository enterpriseRepository;

    @InjectMocks
    private EnterprisesService enterprisesService;

    @Test
    void saveEnterprises() {
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("Adesso");
        enterprise.setUrlId("Adesso2023");

        when(enterpriseRepository.save(enterprise)).thenReturn(enterprise);

        Enterprise savedEnterprise = enterprisesService.saveEnterprise(enterprise);

        assertThat(savedEnterprise).isNotNull();
        assertThat(savedEnterprise.getEnterpriseName()).isEqualTo("Adesso");
        assertThat(savedEnterprise.getUrlId()).isEqualTo("Adesso2023");
    }
}