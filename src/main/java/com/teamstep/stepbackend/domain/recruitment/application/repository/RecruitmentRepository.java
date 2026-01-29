package com.teamstep.stepbackend.domain.recruitment.application.repository;

import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitmentRepository extends JpaRepository<Recruitment, String>, JpaSpecificationExecutor<Recruitment> {
    List<Recruitment> findByCompany(String company);
}
