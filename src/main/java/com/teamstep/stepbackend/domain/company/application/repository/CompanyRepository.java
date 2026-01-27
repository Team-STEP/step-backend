package com.teamstep.stepbackend.domain.company.application.repository;

import com.teamstep.stepbackend.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    List<Company> findByCompanyNameAndLocationAndArea(String companyName, String location, String area);
    List<Company> findByCompanyNameAndLocation(String companyName, String location);
    List<Company> findByCompanyNameAndArea(String companyName, String area);
    List<Company> findByLocationAndArea(String location, String area);
    List<Company> findByCompanyName(String companyName);
    List<Company> findByLocation(String location);
    List<Company> findByArea(String area);
}
