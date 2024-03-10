package com.backend.backend.service;

public interface JWTService {
    String generateToken(String id,String name);
    boolean verifyToken(String token);
}
