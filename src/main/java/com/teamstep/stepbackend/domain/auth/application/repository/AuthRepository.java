package com.teamstep.stepbackend.domain.auth.application.repository;

import com.teamstep.stepbackend.domain.auth.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByEmail(String email);
}
