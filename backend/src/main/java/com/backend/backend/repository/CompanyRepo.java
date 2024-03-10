package com.backend.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.backend.backend.entity.Company;

@EnableJpaRepositories
@Repository
public interface CompanyRepo extends JpaRepository<Company,Long>{
    Page<Company> findAll(Pageable pageable);
}