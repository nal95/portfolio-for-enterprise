package com.nal95.portfolioforenterprise.api;

import com.nal95.portfolioforenterprise.model.Enterprise;
import com.nal95.portfolioforenterprise.service.EnterprisesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class EnterprisesController {
    private final EnterprisesService enterprisesService;

    @Autowired
    public EnterprisesController(EnterprisesService enterprisesService) {
        this.enterprisesService = enterprisesService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(EnterprisesController.class);

    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getAllEnterprise() {
        return ResponseEntity.ok(enterprisesService.getAllEnterprises());
    }

    @PostMapping("/create/enterprise")
    public ResponseEntity<Enterprise> saveEnterprise(@RequestBody String enterprise) {
        LOGGER.info("About to create this new enterprise: " + enterprise);
        return ResponseEntity.ok(enterprisesService.saveEnterprise(enterprise));
    }

    @PutMapping("/update/{enterpriseToken}")
    public ResponseEntity<Enterprise> updateEnterprise(@PathVariable String enterpriseToken, @RequestBody String enterpriseName ) {
        return ResponseEntity.ok(enterprisesService.updateEnterpriseInfos(enterpriseToken, enterpriseName));
    }

}
