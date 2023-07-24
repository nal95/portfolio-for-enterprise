package com.nal95.portfolioforenterprise.repos;

import com.nal95.portfolioforenterprise.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Optional<Enterprise> findEnterpriseByEnterpriseToken(String token);
}
