package com.example.audit.repository;

import com.example.audit.domain.Just;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustRepository extends JpaRepository<Just, Long> {
    Just getById(Long id);
}
