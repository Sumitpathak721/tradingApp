package com.backend.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResp {
    private String message;
    private Boolean status;
    private Long id;
    private String username;
    private String token;

    public LoginResp(String msg,Boolean status){
        this.message = msg;
        this.status = status;
    }
}
