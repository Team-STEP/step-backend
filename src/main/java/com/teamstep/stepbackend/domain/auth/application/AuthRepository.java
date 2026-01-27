package com.teamstep.stepbackend.domain.auth.application;

import com.teamstep.stepbackend.domain.auth.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Account, Long> {
    Account findAccountByEmail(String email);
}
