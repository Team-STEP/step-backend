package com.teamstep.stepbackend.domain.company.application.repository;

import com.teamstep.stepbackend.domain.company.entity.Company;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>, JpaSpecificationExecutor<Company> {
    Page<Company> findAll(Specification<Company> spec, Pageable pageable);
}
