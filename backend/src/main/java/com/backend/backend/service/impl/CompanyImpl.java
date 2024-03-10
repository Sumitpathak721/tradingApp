package com.backend.backend.service.impl;

import com.backend.backend.service.CompanyService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.Company;
import com.backend.backend.repository.CompanyRepo;;

@Service
@AllArgsConstructor
public class CompanyImpl implements CompanyService{
    
    private CompanyRepo companyRepo;

    @Override
    public List<Company> getAllCompanyInfo(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,12);
        return companyRepo.findAll(pageable).getContent();
    }
}
