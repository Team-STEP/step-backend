package com.teamstep.stepbackend.domain.recruitment.application.repository;

import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentRepository extends JpaRepository<Recruitment, String> {
    List<Recruitment> findByCompany(String company);
}
