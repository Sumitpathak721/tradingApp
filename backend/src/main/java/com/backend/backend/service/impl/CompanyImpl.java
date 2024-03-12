package com.backend.backend.service.impl;

import com.backend.backend.service.CompanyService;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.backend.entity.Company;
import com.backend.backend.repository.CompanyRepo;
import com.backend.backend.response.StockResp;

@Service
@AllArgsConstructor
public class CompanyImpl implements CompanyService{
    
    private CompanyRepo companyRepo;

    @Override
    public List<Company> getAllCompanyInfo(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,12);
        return companyRepo.findAll(pageable).getContent();
    }

    @Override
    public StockResp getCandleStockPrice(String ticker,String duration){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate = "";
        String endDate = currentDate.format(formatter);
        String res = "";
        try{
        
        System.out.println(endDate);
        if(duration.equals("1D")){
            startDate = currentDate.minusDays(1).format(formatter);    
            System.out.println(startDate);
            res = "H";
        }else if(duration.equals("3D")){
            startDate = currentDate.minusDays(3).format(formatter);    
            res = "3H";
        }else if(duration.equals("1W")){
            startDate = currentDate.minusWeeks(1).format(formatter);
            res = "6H";
        }else if(duration.equals("1M")){
            startDate = currentDate.minusMonths(1).format(formatter);
            res = "1D";
        }else if(duration.equals("3M")){
            startDate = currentDate.minusMonths(3).format(formatter);
            res = "3D";
        }else{
            startDate = currentDate.minusYears(1).format(formatter);
            res = "2W";
        }
        
        String url = "https://api.marketdata.app/v1/stocks/candles/"+res+"/"+ticker+"/?format=json&from="+startDate+"&to="+endDate+"&dateformat=timestamp&human=true&token=UzdBMFRKZE1GV3REdVMzUHhhN2RZdGd6aktxUlRuSHlJNXUtVVpxX1d6OD0";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StockResp> resp= restTemplate.getForEntity(url, StockResp.class);
        return resp.getBody();
        }catch(Exception e){
            System.out.println("e1 => "+e);
            try{
                String temp = "https://api.marketdata.app/v1/stocks/candles/"+res+"/"+ticker+"/?format=json&from="+startDate+"&to="+endDate+"&dateformat=timestamp&human=true&token=anYwSEthSlc2Z3BJbGc3WjlwelktTjd4RHZXclB3THl6SEYyNFVrVkVIZz0";
                System.out.println(temp);
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<StockResp> resp= restTemplate.getForEntity(temp, StockResp.class);
                return resp.getBody();
            }catch(Exception e2){
                System.out.println("e2 => "+e2);
                return null;
            }
        }
    }
}
