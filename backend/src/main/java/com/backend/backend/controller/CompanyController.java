package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.Company;
import com.backend.backend.response.StockResp;
import com.backend.backend.service.CompanyService;
import com.backend.backend.service.JWTService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    
    @Autowired
    public CompanyService companyService;

    @Autowired
    public JWTService jwtService;

    @GetMapping(path="/all/{pageNumber}")
    public ResponseEntity<List<Company>> getAllCompanyInfo(@PathVariable("pageNumber") int pageNumber){
        List<Company> arr= companyService.getAllCompanyInfo(pageNumber);
        return ResponseEntity.ok(arr);
    }
    @GetMapping(path="/stock/candle/{ticker}/{duration}")
    public StockResp getCandleStockPrice(
        @RequestHeader(value="Authorization",required=false) String userToken,
        @PathVariable("ticker") String ticker,
        @PathVariable("duration") String duration
        ){
        boolean isValidUser = jwtService.verifyToken(userToken);
        if(userToken!=null && isValidUser){
            StockResp resp =  companyService.getCandleStockPrice(ticker,duration);
            return resp;
        }
        return null;
    }
}
