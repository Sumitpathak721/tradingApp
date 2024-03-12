package com.backend.backend.service;

import java.util.List;

import com.backend.backend.entity.Company;
import com.backend.backend.response.StockResp;

public interface CompanyService {
    List<Company> getAllCompanyInfo(int pageNumber);
    StockResp getCandleStockPrice(String ticker,String duration);
}
