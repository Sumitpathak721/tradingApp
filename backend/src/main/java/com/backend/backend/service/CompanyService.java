package com.backend.backend.service;

import java.util.List;

import com.backend.backend.entity.Company;

public interface CompanyService {
    List<Company> getAllCompanyInfo(int pageNumber);
}
