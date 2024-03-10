package com.backend.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransectionDto {
    
    private Long id;
    private UserDto userID;
    private CompanyDto companyID;
    private int amount;
}
