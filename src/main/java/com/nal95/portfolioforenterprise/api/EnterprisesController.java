package com.nal95.portfolioforenterprise.api;

import com.nal95.portfolioforenterprise.model.Enterprise;
import com.nal95.portfolioforenterprise.repos.EnterpriseRepository;
import com.nal95.portfolioforenterprise.service.EnterprisesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class EnterprisesController {

    private final EnterpriseRepository enterprisesRepository;
    private final EnterprisesService enterprisesService;

    @Autowired
    public EnterprisesController(EnterpriseRepository enterprisesRepository, EnterprisesService enterprisesService) {
        this.enterprisesRepository = enterprisesRepository;
        this.enterprisesService = enterprisesService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(EnterprisesController.class);

    @GetMapping("/enterprises")
    public List<Enterprise> getAllEnterprise() {
        return enterprisesService.getAllEnterprises();
    }

    @PostMapping("/create/enterprise")
    public Enterprise saveEnterprise(@RequestBody Enterprise enterprise) {
        return enterprisesService.saveEnterprise(enterprise);
    }

}
