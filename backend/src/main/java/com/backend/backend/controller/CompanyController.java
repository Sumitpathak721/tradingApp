package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.Company;
import com.backend.backend.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    
    @Autowired
    public CompanyService companyService;

    @GetMapping(path="/all/{pageNumber}")
    public ResponseEntity<List<Company>> getAllCompanyInfo(@PathVariable("pageNumber") int pageNumber){
        List<Company> arr= companyService.getAllCompanyInfo(pageNumber);
        return ResponseEntity.ok(arr);
    }
    // @PostMapping(path="/stock/{ticker}")
    // public ResponseEntity<List>
    
}
